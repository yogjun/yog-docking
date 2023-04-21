package cn.yog.docking.executor.executor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import cn.yog.docking.executor.executor.abstracts.AbstractExecutor;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ApiRestErrorException;
import cn.yogjun.docking.invoke.handler.rest.RestKit;
import cn.yogjun.docking.source.manager.bean.api.ApiRestSource;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.core.Resource;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ApiRestExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
@Resource(type = SourceTypeAlias.REST)
public class ApiRestExecutor extends AbstractExecutor<ApiRestSource> {

  @Override
  public void sourceExecute(SourceBean<ApiRestSource> source, Params params) {
    ApiRestSource apiRestSource = source.getSpec();
    String method = apiRestSource.getMethod();
    String url = apiRestSource.getUrl();
    HttpResponse httpResponse;
    if (StrUtil.equals(method, RequestMethod.GET.name())) {
      httpResponse = RestKit.getDelegate().getToResponse(url, params.asMap(), getHeaders());
    } else if (StrUtil.equals(method, RequestMethod.POST.name())) {
      httpResponse = RestKit.getDelegate().postToResponse(url, params.toJson(), getHeaders());
    } else {
      throw new ApiRestErrorException(
          ApiRestErrorException.Code.UNSUPPORT_METHOD, source.toString());
    }
    String response = httpResponse.body();
    httpResponse.getStatus();
    httpResponse.headers();
    params.setResponse(response);
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
