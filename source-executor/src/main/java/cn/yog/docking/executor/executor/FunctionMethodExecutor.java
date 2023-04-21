package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.executor.abstracts.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.invoke.handler.method.MethodUtil;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.function.FunctionMethodSource;
import cn.yogjun.docking.source.manager.resource.Resource;

/**
 * {@link FunctionMethodExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Resource(type = SourceTypeAlias.METHOD_FUNCTION)
public class FunctionMethodExecutor extends AbstractExecutor<FunctionMethodSource> {

  @Override
  public void sourceExecute(SourceBean<FunctionMethodSource> source, Params params) {
    FunctionMethodSource functionMethodSource = source.getSpec();
    Object response =
        MethodUtil.invokeMethod(
            functionMethodSource.getClassName(),
            functionMethodSource.getMethodName(),
            params.asList());
    params.setResponse(response);
  }
}
