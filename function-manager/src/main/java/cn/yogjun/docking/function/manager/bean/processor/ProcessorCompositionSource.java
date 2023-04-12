package cn.yogjun.docking.function.manager.bean.processor;

import cn.yogjun.docking.function.manager.bean.base.SourceBean;
import cn.yogjun.docking.function.manager.bean.base.SourceSpec;
import lombok.Data;

import java.util.List;

/**
 * {@link ProcessorCompositionSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class ProcessorCompositionSource extends SourceSpec {
  private List<SourceBean> cps;
}
