package cn.yogjun.docking.source.manager.support.db;

import cn.hutool.core.lang.Pair;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;

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
  protected Map<String, Object> loadSource(Pair<String, Integer> key) {
    Map<String, Object> mapSource = new LinkedHashMap<>();
    mapSource.put("id", key.getKey());
    mapSource.put("version", key.getValue());
    mapSource.put("type", "property-string");
    Map<String, Object> spec = new LinkedHashMap<>();
    spec.put("value", "mock str");
    mapSource.put("spec", spec);
    if (mapSource == null) {
      throw new ErrorSourceException(ErrorSourceException.Code.NOT_FOUND, "dbSource");
    }
    return mapSource;
  }
}
