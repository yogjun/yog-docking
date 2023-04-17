package cn.yog.docking.executor.executor.impl;

import cn.hutool.core.util.StrUtil;
import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.invoke.handler.method.MethodUtil;
import cn.yogjun.docking.invoke.handler.wsdl.WebServiceUtil;
import cn.yogjun.docking.source.manager.bean.api.ApiWsdlSource;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * {@link ApiWsdlExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Slf4j
@Component(value = SourceExecutorAlias.WSDL)
public class ApiWsdlExecutor extends AbstractExecutor<ApiWsdlSource> {

  public ApiWsdlExecutor(SourceBean<ApiWsdlSource> source) {
    super(source);
  }

  @Override
  public boolean preHandleSource(SourceBean<ApiWsdlSource> source) {
    ApiWsdlSource apiWsdlSource = source.getSpec();
    if (!StrUtil.isAllNotBlank(
        apiWsdlSource.getUrl(), apiWsdlSource.getMethodName(), apiWsdlSource.getServiceClass())) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, source.toString());
    }
    try {
      Class<?> clazz = Class.forName(apiWsdlSource.getServiceClass());
      apiWsdlSource.setClazz(clazz);
    } catch (ClassNotFoundException e) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, source.toString());
    }
    return true;
  }

  @Override
  public void sourceExecute(SourceBean<ApiWsdlSource> source, Params params) {
    ApiWsdlSource apiWsdlSource = source.getSpec();
    Class<?> clazz = apiWsdlSource.getClazz();
    Object service = WebServiceUtil.getWebServiceByUrl(clazz, apiWsdlSource.getUrl());
    Object response =
        MethodUtil.invokeMethod(service, apiWsdlSource.getMethodName(), params.asList());
    params.setResponse(response);
  }
}
