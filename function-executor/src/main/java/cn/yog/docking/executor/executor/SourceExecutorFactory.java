package cn.yog.docking.executor.executor;

import cn.hutool.extra.spring.SpringUtil;
import cn.yogjun.docking.function.manager.enums.SourceType;

/**
 * {@link SourceExecutorFactory}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public class SourceExecutorFactory {

  private SourceExecutorFactory() {}

  public static <T> SourceExecutor<T> getExecutor(SourceType sourceType) {
    return SpringUtil.getBean(sourceType.getHandlerName());
  }

  public static <T> SourceExecutor<T> getExecutor(Class<T> clazz) {
    return SpringUtil.getBean(clazz.getSimpleName());
  }
}
