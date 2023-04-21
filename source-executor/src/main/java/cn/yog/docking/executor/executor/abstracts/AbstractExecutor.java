package cn.yog.docking.executor.executor.abstracts;

import cn.yog.docking.executor.core.SourceExecutorFactory;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;

/**
 * {@link AbstractExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
public abstract class AbstractExecutor<T extends SourceSpec> implements SourceExecutor<T> {

  public AbstractExecutor() {}

  /** 资源执行 */
  protected abstract void sourceExecute(SourceBean<T> source, Params params);

  public void execute(SourceBean source, Params params) {
    source
        .getRequestHandlers()
        .forEach(
            (parameter, s) -> {
              SourceExecutor se = SourceExecutorFactory.getExecutor(s);
              se.execute(s, params);
            });
    // 资源实际执行
    this.sourceExecute(source, params);
    source
        .getResponseHandlers()
        .forEach(
            (parameter, s) -> {
              SourceExecutor se = SourceExecutorFactory.getExecutor(s);
              se.execute(s, params);
            });
  }
}
