package cn.yog.docking.executor.executor.impl;

import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.executor.SourceExecutorFactory;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import org.springframework.stereotype.Component;

/**
 * {@link ProcessorReferenceExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Component(value = SourceTypeAlias.PROCESSOR_REFERENCE)
public class ProcessorReferenceExecutor extends AbstractExecutor<SourceBean> {
  @Override
  protected void sourceExecute(SourceBean<SourceBean> source, Params params) {
    SourceExecutor se = SourceExecutorFactory.getExecutor(source.getSpec());
    se.execute(source.getSpec(), params);
  }
}
