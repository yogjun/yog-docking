package cn.yog.docking.executor.executor.impl.property;

import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.property.PropertyIntegerSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * {@link PropertyIntegerExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Slf4j
@Component(value = SourceExecutorAlias.WSDL)
public class PropertyIntegerExecutor extends AbstractExecutor<PropertyIntegerSource> {

  @Override
  public boolean preHandleSource(SourceBean<PropertyIntegerSource> source) {
    PropertyIntegerSource propertyIntegerSource = source.getSpec();
    return true;
  }

  @Override
  public void sourceExecute(SourceBean<PropertyIntegerSource> source, Params params) {
    PropertyIntegerSource propertyIntegerSource = source.getSpec();
    params.setResponse(propertyIntegerSource.getValue());
  }
}
