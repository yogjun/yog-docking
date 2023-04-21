package cn.yogjun.docking.source.manager.bean.processor;

import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.core.SourceBuilderFactory;
import cn.yogjun.docking.source.manager.core.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link ProcessorNestedSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@Resource(type = SourceTypeAlias.PROCESSOR_NESTED)
public class ProcessorNestedSource extends SourceSpec {
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
    return SourceBuilderFactory.getSourceHandleBuilder(SourceTypeAlias.PUBLIC).build(map);
  }
}
