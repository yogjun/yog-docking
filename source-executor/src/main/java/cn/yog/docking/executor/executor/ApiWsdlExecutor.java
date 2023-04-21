package cn.yog.docking.executor.executor;

import cn.yog.docking.executor.executor.abstracts.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.invoke.handler.method.MethodUtil;
import cn.yogjun.docking.invoke.handler.wsdl.WebServiceUtil;
import cn.yogjun.docking.source.manager.bean.api.ApiWsdlSource;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import lombok.extern.slf4j.Slf4j;
import cn.yogjun.docking.source.manager.resource.Resource;

/**
 * {@link ApiWsdlExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Slf4j
@Resource(type = SourceTypeAlias.WSDL)
public class ApiWsdlExecutor extends AbstractExecutor<ApiWsdlSource> {

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
