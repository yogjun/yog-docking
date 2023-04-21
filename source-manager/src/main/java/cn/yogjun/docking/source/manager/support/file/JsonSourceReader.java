package cn.yogjun.docking.source.manager.support.file;

import cn.yogjun.docking.source.manager.support.AbstractSourceBeanReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

/**
 * {@link JsonSourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
@Slf4j
public class JsonSourceReader extends AbstractSourceBeanReader<Reader> {

  private ObjectMapper objectMapper;

  public JsonSourceReader() {
    this(new ObjectMapper());
  }

  public JsonSourceReader(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  protected Map<String, Object> loadSource(Reader reader) {
    try {
      return objectMapper.readValue(reader, Map.class);
    } catch (IOException e) {
      log.error("parse source error");
    }
    return null;
  }
}
