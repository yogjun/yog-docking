package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.core.SourceExecutorFactory;
import cn.yog.docking.executor.executor.abstracts.AbstractExecutor;
import cn.yog.docking.executor.executor.abstracts.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.processor.ProcessorReferenceSource;
import cn.yogjun.docking.source.manager.core.Resource;

/**
 * {@link ProcessorReferenceExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Resource(type = SourceTypeAlias.PROCESSOR_REFERENCE)
public class ProcessorReferenceExecutor extends AbstractExecutor<ProcessorReferenceSource> {
  @Override
  protected void sourceExecute(SourceBean<ProcessorReferenceSource> source, Params params) {
    ProcessorReferenceSource processorReferenceSource = source.getSpec();
    SourceExecutor se = SourceExecutorFactory.getExecutor(processorReferenceSource.getSource());
    se.execute(processorReferenceSource.getSource(), params);
  }
}
