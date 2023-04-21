package cn.yogjun.docking.source.manager.support.db;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link MongoSourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/21
 */
public class MongoSourceReader extends AbstractIdSourceReader {
  @Override
  protected Map<String, Object> loadSource(String source) {
    Map<String, Object> mapSource = new LinkedHashMap<>();
    mapSource.put("id", source);
    mapSource.put("type", "property-string");
    Map<String, Object> spec = new LinkedHashMap<>();
    spec.put("value", "mock str");
    mapSource.put("spec", spec);
    return mapSource;
  }
}
