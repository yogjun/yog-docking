package cn.yog.docking.executor.executor.impl;

import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
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
@Component(value = SourceTypeAlias.METHOD_SPRING_FUNCTION)
public class FunctionSpringMethodExecutor extends AbstractExecutor<FunctionSpringMethodSource> {

  @Override
  public void sourceExecute(SourceBean<FunctionSpringMethodSource> source, Params params) {
    FunctionSpringMethodSource functionMethodSource = source.getSpec();
    Object response =
        SpringMethodUtil.springInvokeMethod(
            functionMethodSource.getBeanId(),
            functionMethodSource.getMethodName(),
            params.asList());
    params.setResponse(response);
  }
}
