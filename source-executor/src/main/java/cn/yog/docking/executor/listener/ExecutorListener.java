package cn.yog.docking.executor.listener;

import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;

/**
 * {@link ExecutorListener} 执行单个source spec的监听器
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public interface ExecutorListener {

  void beforeExecute(SourceBean source, Params param);

  void afterExecute(SourceBean source, Params param);
}
