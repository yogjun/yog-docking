package cn.yog.docking.executor.executor;

import cn.hutool.extra.spring.SpringUtil;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;

/**
 * {@link SourceExecutorFactory}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public class SourceExecutorFactory {

  private SourceExecutorFactory() {}

  public static SourceExecutor getExecutor(SourceBean sourceBean) {
    SourceExecutor se = SpringUtil.getBean(sourceBean.getType());
    return se;
  }

  //  public static SourceExecutor getExecutor(SourceType sourceType) {
  //    return getExecutor(sourceType.getHandlerName());
  //  }
  //
  //  public static SourceExecutor getExecutor(String type) {
  //    return SpringUtil.getBean(type);
  //  }
}
