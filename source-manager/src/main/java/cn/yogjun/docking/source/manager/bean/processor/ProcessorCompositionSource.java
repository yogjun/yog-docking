package cn.yogjun.docking.source.manager.bean.processor;

import cn.yogjun.docking.source.manager.bean.base.SourceBean;
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
public class ProcessorCompositionSource extends SourceSpec implements Iterable<SourceBean> {
  private List<SourceBean> sources;

  @Override
  public Iterator<SourceBean> iterator() {
    return this.sources.iterator();
  }
}
