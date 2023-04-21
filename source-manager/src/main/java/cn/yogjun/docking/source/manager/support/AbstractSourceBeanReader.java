package cn.yogjun.docking.source.manager.support;

import cn.yogjun.docking.source.manager.bean.base.RootSourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;

import java.io.Reader;
import java.util.Map;

/**
 * {@link AbstractSourceBeanReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/18
 */
public abstract class AbstractSourceBeanReader implements SourceReader {

  // todo read from db（by id）
  public RootSourceBean read(Reader reader) {
    Map<String, Object> sources = loadSource(reader);
    return createSource(sources);
  }

  protected abstract Map<String, Object> loadSource(Reader reader);

  protected RootSourceBean createSource(Map<String, Object> map) {
    return (RootSourceBean) new RootSourceBean().build(map);
  }
}
