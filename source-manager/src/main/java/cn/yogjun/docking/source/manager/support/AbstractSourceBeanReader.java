package cn.yogjun.docking.source.manager.support;

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

  public SourceBean read(Reader reader) {
    Map<String, Object> sources = loadSource(reader);
    return createSource(sources);
  }

  protected abstract Map<String, Object> loadSource(Reader reader);

  protected SourceBean createSource(Map<String, Object> map) {
    return (SourceBean) new SourceBean().build(map);
  }
}
