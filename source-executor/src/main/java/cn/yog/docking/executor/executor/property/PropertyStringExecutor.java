package cn.yog.docking.executor.executor.property;

import cn.yog.docking.executor.executor.abstracts.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.property.PropertyIntegerSource;
import lombok.extern.slf4j.Slf4j;
import cn.yog.docking.executor.core.Executor;

/**
 * {@link PropertyStringExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Slf4j
@Executor(type = SourceTypeAlias.PROPERTY_STRING)
public class PropertyStringExecutor extends AbstractExecutor<PropertyIntegerSource> {

  @Override
  public void sourceExecute(SourceBean<PropertyIntegerSource> source, Params params) {
    PropertyIntegerSource propertyIntegerSource = source.getSpec();
    params.setResponse(propertyIntegerSource.getValue());
  }
}
