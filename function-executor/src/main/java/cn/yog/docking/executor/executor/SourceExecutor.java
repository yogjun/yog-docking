package cn.yog.docking.executor.executor;

import cn.yogjun.docking.function.manager.bean.base.Source;

/**
 * {@link SourceExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public interface SourceExecutor<T> {

  void execute(Source source);

  //  List<SourceExecutor> getNextExecutors();

  //  void setNext();
}
