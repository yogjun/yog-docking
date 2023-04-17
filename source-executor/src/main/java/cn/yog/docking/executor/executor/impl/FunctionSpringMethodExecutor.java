package cn.yog.docking.executor.executor.impl;

import cn.hutool.core.util.StrUtil;
import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.invoke.handler.method.SpringMethodUtil;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.function.FunctionSpringMethodSource;
import org.springframework.stereotype.Component;

/**
 * {@link FunctionSpringMethodExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Component(value = SourceExecutorAlias.METHOD_SPRING_FUNCTION)
public class FunctionSpringMethodExecutor extends AbstractExecutor<FunctionSpringMethodSource>
    implements SourceExecutor<FunctionSpringMethodSource> {

  public FunctionSpringMethodExecutor(SourceBean<FunctionSpringMethodSource> source) {
    super(source);
  }

  @Override
  public boolean validateSource(SourceBean<FunctionSpringMethodSource> source) {
    FunctionSpringMethodSource functionSpringMethodSource = source.getSpec();
    if (StrUtil.isAllNotBlank(
        functionSpringMethodSource.getMethodName(), functionSpringMethodSource.getBeanId())) {
      return true;
    }
    throw new ErrorSourceException(
        ErrorSourceException.Code.SOURCE_FORMAT_ERROR, source.toString());
  }

  @Override
  public void execute(SourceBean<FunctionSpringMethodSource> source, Params params) {
    FunctionSpringMethodSource functionMethodSource = source.getSpec();
    Object response =
        SpringMethodUtil.springInvokeMethod(
            functionMethodSource.getBeanId(),
            functionMethodSource.getMethodName(),
            params.asList());
    // todo response 结果处理
  }
}
