package cn.yog.docking.executor;

import cn.yogjun.docking.function.manager.bean.base.SourceBean;

/**
 * {@link SourceExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public interface SourceExecutor<T> {

  void execute(SourceBean source);

  //  List<SourceExecutor> getNextExecutors();

  //  void setNext();
}
