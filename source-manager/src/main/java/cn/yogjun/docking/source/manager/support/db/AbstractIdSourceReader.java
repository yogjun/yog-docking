package cn.yogjun.docking.source.manager.support.db;

import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.support.AbstractSourceBeanReader;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link AbstractIdSourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
@Slf4j
public abstract class AbstractIdSourceReader extends AbstractSourceBeanReader<String> {

  private static Map<String, SourceBean> cacheSource = new ConcurrentHashMap<>();

  public SourceBean read(String id) {
    if (cacheSource.containsKey(id)) {
      return cacheSource.get(id);
    }
    Map<String, Object> sources = loadSource(id);
    SourceBean sb = createSource(sources);
    cacheSource.put(id, sb);
    return sb;
  }

  protected abstract Map<String, Object> loadSource(String source);
}
