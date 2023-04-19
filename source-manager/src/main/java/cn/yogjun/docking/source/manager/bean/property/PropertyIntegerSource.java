package cn.yogjun.docking.source.manager.bean.property;

import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.resource.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link PropertyIntegerSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@Resource(type = SourceTypeAlias.PROPERTY_INTEGER)
public class PropertyIntegerSource extends SourceSpec {
  private Integer value;

  @Override
  public void checkSource() {
    if (null == value) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  protected SourceSpec buildSource(Map<String, Object> map) {
    PropertyIntegerSource propertyIntegerSource = new PropertyIntegerSource();
    propertyIntegerSource.setValue((Integer) map.get("value"));
    return propertyIntegerSource;
  }
}
