package cn.yogjun.docking.source.manager.bean.function;

import cn.hutool.core.util.StrUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.resource.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link FunctionSpringMethodSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@Resource(type = SourceTypeAlias.METHOD_SPRING_FUNCTION)
public class FunctionSpringMethodSource extends SourceSpec {

  private String beanId;
  private String methodName;

  @Override
  public void checkSource() {
    if (!StrUtil.isAllNotBlank(this.getMethodName(), this.getBeanId())) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  protected SourceSpec buildSource(Map<String, Object> map) {
    FunctionSpringMethodSource functionSpringMethodSource = new FunctionSpringMethodSource();
    functionSpringMethodSource.setBeanId((String) map.get("beanId"));
    functionSpringMethodSource.setMethodName((String) map.get("methodName"));
    return functionSpringMethodSource;
  }
}
