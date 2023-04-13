package cn.yog.docking.executor.listener;

import cn.yogjun.docking.function.manager.bean.base.Source;

/**
 * {@link SourceListener}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public interface SourceListener {
  boolean beforeEvaluate(Source source, Params param);

  void afterEvaluate(Source source, Params param, boolean var3);

  void beforeExecute(Source source, Params param);

  void onSuccess(Source source, Params param);

  void onFailure(Source source, Params param, Exception e);
}
