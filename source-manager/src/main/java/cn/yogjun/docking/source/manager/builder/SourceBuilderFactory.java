package cn.yogjun.docking.source.manager.builder;

import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceHandle;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.resource.ResourceManager;

/**
 * {@link SourceBuilderFactory}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
public class SourceBuilderFactory {
  private SourceBuilderFactory() {}

  public static SourceHandle getSourceHandleBuilder(String type) {
    try {
      Class<SourceSpec> resourceClass = ResourceManager.getResourceClass(type);
      if (resourceClass == null) {
        throw new ErrorSourceException(ErrorSourceException.Code.NOT_FOUND, "");
      }
      return resourceClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new ErrorSourceException(ErrorSourceException.Code.SOURCE_FORMAT_ERROR, "");
    }
  }
}
