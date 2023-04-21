package cn.yogjun.docking.source.manager.core;

import cn.hutool.core.util.ClassUtil;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceHandle;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link SourceBuilderFactory}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
public class SourceBuilderFactory {
  private SourceBuilderFactory() {}

  private static Map<String, Class<SourceSpec>> resourceMap;

  static {
    resourceMap = initResourceMap();
  }

  public static <T extends SourceSpec> Map<String, Class<T>> initResourceMap() {
    Map<String, Class<T>> resourceMap = new HashMap<>();
    for (Class<?> clazz : ClassUtil.scanPackageByAnnotation(null, Resource.class)) {
      Resource resource = clazz.getAnnotation(Resource.class);
      String resourceType = resource.type();
      if (resourceMap.containsKey(resourceType)) {
        throw new RuntimeException(
            "[init resource map] error: resource duplicate; type=" + resourceType);
      }
      if (!SourceSpec.class.isAssignableFrom(clazz)) {
        throw new RuntimeException("[init resource map] error: class error");
      }
      resourceMap.put(resourceType, (Class<T>) clazz);
    }
    return resourceMap;
  }

  private static Class<SourceSpec> getResourceClass(String identification) {
    return resourceMap.get(identification);
  }

  public static SourceHandle getSourceHandleBuilder(String type) {
    try {
      Class<SourceSpec> resourceClass = getResourceClass(type);
      if (resourceClass == null) {
        throw new ErrorSourceException(ErrorSourceException.Code.NOT_FOUND, "");
      }
      return resourceClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new ErrorSourceException(ErrorSourceException.Code.SOURCE_FORMAT_ERROR, "");
    }
  }
}
