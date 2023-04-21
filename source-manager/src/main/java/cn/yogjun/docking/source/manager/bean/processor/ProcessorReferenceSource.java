package cn.yogjun.docking.source.manager.bean.processor;

import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.bean.property.PropertyStringSource;
import cn.yogjun.docking.source.manager.core.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link ProcessorReferenceSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@Resource(type = SourceTypeAlias.PROCESSOR_REFERENCE)
public class ProcessorReferenceSource extends SourceSpec {
  private SourceBean source;

  @Override
  public void checkSource() {
    if (null == source) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  protected SourceSpec buildSource(Map<String, Object> map) {
    // id
    String id = (String) map.get("id");

    // todo 根据id获取资源
    SourceBean sourceBean = new SourceBean(); // 根据id获取的source
    // mock 数据
    sourceBean.setId(id);
    sourceBean.setType("property-string");
    sourceBean.setSpec(new PropertyStringSource("1"));

    // 获取后check
    sourceBean.checkSource();
    return sourceBean;
  }
}
