package cn.yog.docking.executor.core;

import cn.hutool.core.util.ClassUtil;
import cn.yog.docking.executor.executor.abstracts.SourceExecutor;
import cn.yogjun.docking.bean.exceptions.ErrorExecutorException;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.core.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * {@link SourceExecutorFactory}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public class SourceExecutorFactory {

  private SourceExecutorFactory() {}

  private static Map<String, SourceExecutor> executorMap;

  static {
    executorMap = initExecutorMap();
  }

  public static Map<String, SourceExecutor> initExecutorMap() {
    Map<String, SourceExecutor> executorMap = new HashMap<>();
    for (Class<?> clazz : ClassUtil.scanPackageByAnnotation(null, Executor.class)) {
      Executor executor = clazz.getAnnotation(Executor.class);

      String resourceType = executor.type();
      if (executorMap.containsKey(resourceType)) {
        throw new RuntimeException(
            "[init cn.yog.docking.kits.executor map] error: cn.yog.docking.kits.executor duplicate; type=" + resourceType);
      }
      if (!SourceExecutor.class.isAssignableFrom(clazz)) {
        throw new RuntimeException("[init cn.yog.docking.kits.executor map] error: class error");
      }
      try {
        executorMap.put(resourceType, (SourceExecutor) clazz.newInstance());
      } catch (InstantiationException | IllegalAccessException e) {
        throw new RuntimeException("[init cn.yog.docking.kits.executor map] error: instance error", e);
      }
    }
    return executorMap;
  }

  public static SourceExecutor getExecutor(SourceBean sourceBean) {
    SourceExecutor se = executorMap.get(sourceBean.getType());
    if (Objects.isNull(se)) {
      throw new ErrorExecutorException(ErrorExecutorException.Code.NOT_FOUND, "");
    }
    return se;
  }
}
