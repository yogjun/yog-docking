package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.listener.SourceListener;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link AbstractExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
public abstract class AbstractExecutor<T extends SourceSpec> implements SourceExecutor<T> {
  private SourceBean<T> source;

  @Deprecated private List<SourceListener> sourceListeners;

  public AbstractExecutor(SourceBean<T> source) {
    this.source = source;
    this.sourceListeners = new ArrayList();
  }

  public SourceBean<T> getSource() {
    return source;
  }
}