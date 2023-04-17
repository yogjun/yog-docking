package cn.yog.docking.executor.executor;

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

  /** 资源预处理（包含预处理） */
  protected abstract boolean preHandleSource(SourceBean<T> source);

  public void execute(SourceBean source, Params params) {
    // 预处理资源（含资源处理，资源格式校验等）
    this.preHandleSource(source);
    // todo  before execute
    //    source.getRequestHandlers().entrySet().forEach();
    // 资源实际执行
    this.sourceExecute(source, params);
    // todo  after execute
    //    source.getResponseHandlers().entrySet().forEach();
  }
}
