package cn.yog.docking.executor.executor.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import cn.yog.docking.executor.executor.AbstractExecutor;
import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import cn.yogjun.docking.bean.exceptions.ApiRestErrorException;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.invoke.handler.rest.RestKit;
import cn.yogjun.docking.source.manager.bean.api.ApiRestSource;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ApiRestExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Component(value = SourceExecutorAlias.REST)
public class ApiRestExecutor extends AbstractExecutor<ApiRestSource>
    implements SourceExecutor<ApiRestSource> {

  public ApiRestExecutor(SourceBean<ApiRestSource> source) {
    super(source);
  }

  @Override
  public boolean validateSource(SourceBean<ApiRestSource> source) {
    ApiRestSource apiRestSource = source.getSpec();
    if (StrUtil.isAllNotBlank(apiRestSource.getMethod(), apiRestSource.getUrl())) {
      return true;
    }
    throw new ErrorSourceException(
        ErrorSourceException.Code.SOURCE_FORMAT_ERROR, source.toString());
  }

  @Override
  public void execute(SourceBean<ApiRestSource> source, Params params) {
    ApiRestSource apiRestSource = source.getSpec();
    String method = apiRestSource.getMethod();
    String url = apiRestSource.getUrl();
    HttpResponse httpResponse;
    if (StrUtil.equals(method, RequestMethod.GET.name())) {
      httpResponse = RestKit.getDelegate().getToResponse(url, params.asMap(), getHeaders());
    } else if (StrUtil.equals(method, RequestMethod.POST.name())) {
      httpResponse = RestKit.getDelegate().postToResponse(url, params.toString(), getHeaders());
    } else {
      throw new ApiRestErrorException(
          ApiRestErrorException.Code.UNSUPPORT_METHOD, source.toString());
    }
    String response = httpResponse.body();
    httpResponse.getStatus();
    httpResponse.headers();
    // todo 计算结果处理 （需要整理一整套上下文管理）
  }

  private Map<String, String> getHeaders() {
    Map<String, String> headers = getBaseHeaders();
    headers.put("Content-Type", ContentType.JSON.toString());
    return headers;
  }

  private Map<String, String> getBaseHeaders() {
    Map<String, String> headers = new HashMap<>(5);
    headers.put("Accept", ContentType.JSON.toString());
    return headers;
  }
}
