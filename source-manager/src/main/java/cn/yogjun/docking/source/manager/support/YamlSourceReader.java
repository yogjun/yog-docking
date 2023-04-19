package cn.yogjun.docking.source.manager.support;

import org.yaml.snakeyaml.Yaml;

import java.io.Reader;
import java.util.Map;

/**
 * {@link YamlSourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public class YamlSourceReader extends AbstractSourceBeanReader {

  private Yaml yaml;

  public YamlSourceReader() {
    this(new Yaml());
  }

  public YamlSourceReader(Yaml yaml) {
    this.yaml = yaml;
  }

  @Override
  protected Map<String, Object> loadSource(Reader reader) {
    return this.yaml.load(reader);
  }
}
