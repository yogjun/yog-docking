package cn.yog.docking.executor.listener;

import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.function.manager.bean.base.Sourcebean;

/**
 * {@link SourceListener}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public interface SourceListener {
  boolean beforeEvaluate(Sourcebean source, Params param);

  void afterEvaluate(Sourcebean source, Params param, boolean var3);

  void beforeExecute(Sourcebean source, Params param);

  void onSuccess(Sourcebean source, Params param);

  void onFailure(Sourcebean source, Params param, Exception e);
}
