package cn.yog.docking.executor.executor.impl;

import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.api.ApiRestSource;
import cn.yogjun.docking.source.manager.bean.base.Sourcebean;

/**
 * {@link ApiRestExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
public class ApiRestExecutor extends AbstractExecutor<ApiRestSource>
    implements SourceExecutor<ApiRestSource> {

  public ApiRestExecutor(Sourcebean<ApiRestSource> source) {
    super(source);
  }

  @Override
  public void execute(Sourcebean<ApiRestSource> source, Params params) {

    // todo 处理全局参数


  }
}
