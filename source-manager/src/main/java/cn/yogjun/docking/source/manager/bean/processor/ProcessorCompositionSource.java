package cn.yogjun.docking.source.manager.bean.processor;

import cn.yogjun.docking.source.manager.bean.base.Sourcebean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
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
public class ProcessorCompositionSource extends SourceSpec implements Iterable<Sourcebean> {
  private List<Sourcebean> sources;

  @Override
  public Iterator<Sourcebean> iterator() {
    return this.sources.iterator();
  }
}
