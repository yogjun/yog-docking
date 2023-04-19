package cn.yogjun.docking.source.manager.bean.base;

import cn.hutool.core.util.StrUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import lombok.Data;

/**
 * {@link SourceBean}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
@Data
public class SourceBean<T extends SourceSpec> extends SourceSpec {

  /** id type-group-name,example: "api-rest-ccc-d" */
  private String id;

  private int version;

  /** api-rest */
  private String type;

  private SourceMetaBean metadata;

  /** 是否同步执行 */
  protected boolean sync = true;

  private T spec;

  @Override
  public void checkSource() {
    // 校验类型和id不能为空
    // 规格参数不能为空
    // 资源不包含
    if (!StrUtil.isAllNotBlank(this.getId(), this.getType())
        || null == spec
        || !SourceTypeAlias.sourceTypes.contains(type)) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  //  @Override
  //  public SourceSpec buildSource(Map<String, Object> map) {
  //    SourceBean sourceBean = new SourceBean();
  //    // id
  //    String id = (String) map.get("id");
  //    sourceBean.setId(id);
  //    // version
  //    Integer version = (Integer) map.get("version");
  //    sourceBean.setVersion(null != version ? version : 0);
  //    // order
  //    Integer order = (Integer) map.get("order");
  //    sourceBean.setOrder(null != order ? order : Integer.MAX_VALUE);
  //    // type
  //    String type = (String) map.get("type");
  //    sourceBean.setType(type);
  //    // sync
  //    Boolean sync = (Boolean) map.get("sync");
  //    sourceBean.setSync(null != sync ? sync : false);
  //    // metadata
  //    Map<String, Object> metadata = (Map<String, Object>) map.get("metadata");
  //    sourceBean.setMetadata(
  //            SourceMetaBean.builder()
  //                    .group((String) metadata.get("group"))
  //                    .name((String) metadata.get("name"))
  //                    .remark((String) metadata.get("remark"))
  //                    .build());
  //    // spec
  //    Map<String, Object> spec = (Map<String, Object>) map.get("spec");
  //    sourceBean.setSpec();
  //    sourceBean.checkSource();
  //    return sourceBean;
  //  }
}
