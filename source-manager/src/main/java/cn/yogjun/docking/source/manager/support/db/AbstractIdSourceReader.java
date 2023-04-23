package cn.yogjun.docking.source.manager.support.db;

import cn.hutool.core.lang.Pair;
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
public abstract class AbstractIdSourceReader extends AbstractSourceBeanReader<Pair<String,Integer>> {

  private static Map<Pair<String,Integer>, SourceBean> cacheSource = new ConcurrentHashMap<>();

  public SourceBean read(Pair<String,Integer> key) {
    if (cacheSource.containsKey(key)) {
      return cacheSource.get(key);
    }
    Map<String, Object> sources = loadSource(key);
    SourceBean sb = createSource(sources);
    cacheSource.put(key, sb);
    return sb;
  }

  protected abstract Map<String, Object> loadSource(Pair<String,Integer> source);
}
