package cn.yogjun.docking.function.manager.bean.processor;

import cn.yogjun.docking.function.manager.bean.base.Source;
import cn.yogjun.docking.function.manager.bean.base.SourceSpec;
import lombok.Data;

import java.util.Iterator;
import java.util.List;

/**
 * {@link ProcessorCompositionSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class ProcessorCompositionSource extends SourceSpec implements Iterable<Source> {
  private List<Source> sources;

  @Override
  public Iterator<Source> iterator() {
    return this.sources.iterator();
  }
}
