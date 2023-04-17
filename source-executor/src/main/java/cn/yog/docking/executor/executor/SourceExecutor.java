package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;

/**
 * {@link SourceExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public interface SourceExecutor<T extends SourceSpec> {

  /**
   * check source format
   * @param source
   * @return true:check pass
   */
  boolean validateSource(SourceBean<T> source);

  void execute(SourceBean<T> source, Params params) throws ClassNotFoundException;

  //  List<SourceExecutor> getNextExecutors();

  //  List<SourceListener> getSourceListener();
}
