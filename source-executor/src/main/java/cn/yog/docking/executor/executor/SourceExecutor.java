package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;

/**
 * {@link SourceExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public interface SourceExecutor<T extends SourceSpec> {

  void execute(SourceBean source, Params params);

  //  List<SourceExecutor> getNextExecutors();

  // to opt 添加 处理资源执行监听器 listeners
}
