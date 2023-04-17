package cn.yog.docking.executor.executor.impl;

import cn.hutool.core.util.StrUtil;
import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.invoke.handler.method.MethodUtil;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.function.FunctionMethodSource;
import org.springframework.stereotype.Component;

/**
 * {@link FunctionMethodExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Component(value = SourceExecutorAlias.METHOD_FUNCTION)
public class FunctionMethodExecutor extends AbstractExecutor<FunctionMethodSource>
    implements SourceExecutor<FunctionMethodSource> {

  public FunctionMethodExecutor(SourceBean<FunctionMethodSource> source) {
    super(source);
  }

  @Override
  public boolean validateSource(SourceBean<FunctionMethodSource> source) {
    FunctionMethodSource functionMethodSource = source.getSpec();
    if (StrUtil.isAllNotBlank(
        functionMethodSource.getMethodName(), functionMethodSource.getClassName())) {
      return true;
    }
    throw new ErrorSourceException(
        ErrorSourceException.Code.SOURCE_FORMAT_ERROR, source.toString());
  }

  @Override
  public void execute(SourceBean<FunctionMethodSource> source, Params params) {
    FunctionMethodSource functionMethodSource = source.getSpec();
    Object response =
        MethodUtil.invokeMethod(
            functionMethodSource.getClassName(),
            functionMethodSource.getMethodName(),
            params.asList());
    // todo response 结果处理
  }
}
