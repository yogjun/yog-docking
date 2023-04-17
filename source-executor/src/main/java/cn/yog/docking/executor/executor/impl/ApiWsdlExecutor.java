package cn.yog.docking.executor.executor.impl;

import cn.hutool.core.util.StrUtil;
import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.invoke.handler.method.MethodUtil;
import cn.yogjun.docking.invoke.handler.wsdl.WebServiceUtil;
import cn.yogjun.docking.source.manager.bean.api.ApiWsdlSource;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import org.springframework.stereotype.Component;

/**
 * {@link ApiWsdlExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Component(value = SourceExecutorAlias.WSDL)
public class ApiWsdlExecutor extends AbstractExecutor<ApiWsdlSource>
    implements SourceExecutor<ApiWsdlSource> {

  public ApiWsdlExecutor(SourceBean<ApiWsdlSource> source) {
    super(source);
  }

  @Override
  public boolean validateSource(SourceBean<ApiWsdlSource> source) {
    ApiWsdlSource apiWsdlSource = source.getSpec();
    if (StrUtil.isAllNotBlank(
        apiWsdlSource.getUrl(), apiWsdlSource.getMethodName(), apiWsdlSource.getServiceClass())) {
      return true;
    }
    throw new ErrorSourceException(
        ErrorSourceException.Code.SOURCE_FORMAT_ERROR, source.toString());
  }

  @Override
  public void execute(SourceBean<ApiWsdlSource> source, Params params)
      throws ClassNotFoundException {
    ApiWsdlSource apiWsdlSource = source.getSpec();
    Class<?> clazz = Class.forName(apiWsdlSource.getServiceClass());
    Object service = WebServiceUtil.getWebServiceByUrl(clazz, apiWsdlSource.getUrl());
    Object response =
        MethodUtil.invokeMethod(service, clazz, apiWsdlSource.getMethodName(), params.asList());
  }
}
