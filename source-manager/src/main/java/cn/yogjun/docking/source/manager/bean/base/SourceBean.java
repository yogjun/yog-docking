package cn.yogjun.docking.source.manager.bean.base;

import cn.hutool.core.util.StrUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.resource.SourceBuilderFactory;
import cn.yogjun.docking.source.manager.resource.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link SourceBean}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
@Data
@Resource(type = SourceTypeAlias.PUBLIC, notes = "公共资源，具体执行内容在成员spec中")
public class SourceBean<T extends SourceSpec> extends SourceSpec {

  /** id type-group-name,example: "api-rest-ccc-d" */
  private String id;

  private int version;

  /** api-rest */
  private String type;

  private SourceMetaBean metadata;

  /** 是否同步执行 */
  protected boolean sync = true;

  /** 当出现多个的时候表示顺序 */
  private int order;

  private T spec;

  @Override
  public void checkSource() {
    if (!StrUtil.isAllNotBlank(this.getType()) || !SourceTypeAlias.sourceTypes.contains(type)) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  protected SourceBean getInstance() {
    return new SourceBean();
  }

  @Override
  protected SourceSpec buildSource(Map<String, Object> map) {
    SourceBean sourceBean = getInstance();
    // id
    String id = (String) map.get("id");
    sourceBean.setId(id);
    // type
    String type = (String) map.get("type");
    sourceBean.setType(type);
    // version
    Integer version = (Integer) map.get("version");
    sourceBean.setVersion(null != version ? version : 0);
    // order
    Integer order = (Integer) map.get("order");
    sourceBean.setOrder(null != order ? order : Integer.MAX_VALUE);
    // sync
    Boolean sync = (Boolean) map.get("sync");
    sourceBean.setSync(null != sync ? sync : false);
    // metadata
    Map<String, Object> metadata = (Map<String, Object>) map.get("metadata");
    if (null != metadata) {
      sourceBean.setMetadata(
          SourceMetaBean.builder()
              .group((String) metadata.get("group"))
              .name((String) metadata.get("name"))
              .remark((String) metadata.get("remark"))
              .build());
    }
    // spec
    Map<String, Object> spec = (Map<String, Object>) map.get("spec");
    sourceBean.setSpec(SourceBuilderFactory.getSourceHandleBuilder(type).build(spec));
    return sourceBean;
  }
}
