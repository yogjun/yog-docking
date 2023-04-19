package cn.yogjun.docking.source.manager.bean.function;

import cn.hutool.core.util.StrUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.support.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link FunctionMethodSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@Resource(type = SourceTypeAlias.METHOD_FUNCTION)
public class FunctionMethodSource extends SourceSpec {

  private String className;
  private String methodName;

  @Override
  public void checkSource() {
    if (!StrUtil.isAllNotBlank(this.getMethodName(), this.getClassName())) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  public SourceSpec buildSource(Map<String, Object> map) {
    FunctionMethodSource functionMethodSource = new FunctionMethodSource();
    functionMethodSource.setClassName((String) map.get("className"));
    functionMethodSource.setMethodName((String) map.get("methodName"));
    return functionMethodSource;
  }
}
