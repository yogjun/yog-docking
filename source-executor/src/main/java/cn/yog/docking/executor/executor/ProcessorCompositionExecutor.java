package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.core.Executor;
import cn.yog.docking.executor.core.SourceExecutorFactory;
import cn.yog.docking.executor.executor.abstracts.AbstractExecutor;
import cn.yog.docking.executor.executor.abstracts.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.processor.ProcessorCompositionSource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link ProcessorCompositionExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Executor(type = SourceTypeAlias.PROCESSOR_COMPOSITION)
public class ProcessorCompositionExecutor extends AbstractExecutor<ProcessorCompositionSource> {

  @Override
  protected void sourceExecute(SourceBean<ProcessorCompositionSource> source, Params params) {
    ProcessorCompositionSource compositionSource = source.getSpec();
    List<Object> responses =
        compositionSource.getSources().stream()
            .map(
                sb -> {
                  SourceExecutor se = SourceExecutorFactory.getExecutor(sb);
                  se.execute(sb, params);
                  return params.getResponse();
                })
            .collect(Collectors.toList());
    params.setResponse(responses);
  }
}
