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
  public SourceBean read(Reader reader) throws Exception {
    SourceBean sourceBean = new SourceBean();
    return sourceBean;
  }

  protected abstract Map<String, Object> loadSource(Reader reader) throws Exception;

  protected SourceBean createSource(Map<String, Object> map) {
    SourceBean sourceBean = new SourceBean();
//    sourceBean = (SourceBean) sourceBean.buildSource(map);
    return sourceBean;
  }
}