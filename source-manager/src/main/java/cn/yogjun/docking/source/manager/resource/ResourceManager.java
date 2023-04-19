package cn.yogjun.docking.source.manager.resource;

import cn.hutool.core.util.ClassUtil;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;

import java.util.HashMap;
import java.util.Map;
/**
 * {@link ResourceManager}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
public class ResourceManager {

  private static Map<String, Class<SourceSpec>> resourceMap;

  static {
    resourceMap = new ResourceManager().initResourceMap();
  }

  public <T extends SourceSpec> Map<String, Class<T>> initResourceMap() {
    Map<String, Class<T>> resourceMap = new HashMap<>();
    for (Class<?> clazz : ClassUtil.scanPackageByAnnotation(null, Resource.class)) {
      Resource resource = clazz.getAnnotation(Resource.class);
      String resourceType = resource.type();
      // 判断 resourceMap 中是否存在 identification
      if (resourceMap.containsKey(resourceType)) {
        throw new RuntimeException(
            "[init resource map] error: resource duplicate; type=" + resourceType);
      }
      // 判断 clazz 是否是 AbstractResource.class 的子类
      if (!SourceSpec.class.isAssignableFrom(clazz)) {
        throw new RuntimeException("[init resource map] error: class error");
      }
      resourceMap.put(resourceType, (Class<T>) clazz);
    }
    return resourceMap;
  }

  public static Class<SourceSpec> getResourceClass(String identification) {
    return resourceMap.get(identification);
  }
}
