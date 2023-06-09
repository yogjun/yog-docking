package cn.yogjun.docking.source.manager.bean.property;

import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.core.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * {@link PropertyStringSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Resource(type = SourceTypeAlias.PROPERTY_STRING)
public class PropertyStringSource extends SourceSpec {
  private String value;

  @Override
  public void checkSource() {
    if (null == value) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  protected SourceSpec buildSource(Map<String, Object> map) {
    PropertyStringSource propertyStringSource = new PropertyStringSource();
    propertyStringSource.setValue((String) map.get("value"));
    return propertyStringSource;
  }
}
