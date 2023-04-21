package cn.yogjun.docking.source.manager.support;

import cn.yogjun.docking.source.manager.bean.base.RootSourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;

import java.util.Map;

/**
 * {@link AbstractSourceBeanReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/18
 */
public abstract class AbstractSourceBeanReader<T> implements SourceReader<T> {

  public SourceBean read(T source) {
    Map<String, Object> sources = loadSource(source);
    return createSource(sources);
  }

  protected abstract Map<String, Object> loadSource(T source);

  protected SourceBean createSource(Map<String, Object> map) {
    return (SourceBean) new RootSourceBean().build(map);
  }
}
