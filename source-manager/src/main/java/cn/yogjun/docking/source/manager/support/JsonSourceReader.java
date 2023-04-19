package cn.yogjun.docking.source.manager.support;

import com.google.gson.Gson;

import java.io.Reader;
import java.util.Map;

/**
 * {@link JsonSourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public class JsonSourceReader extends AbstractSourceBeanReader {

  private Gson gson;

  public JsonSourceReader() {
    this(new Gson());
  }

  public JsonSourceReader(Gson gson) {
    this.gson = gson;
  }

  @Override
  protected Map<String, Object> loadSource(Reader reader) throws Exception {
    return gson.fromJson(reader, Map.class);
  }
}
