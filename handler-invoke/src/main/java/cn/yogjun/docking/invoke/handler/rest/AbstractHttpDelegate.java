package cn.yogjun.docking.invoke.handler.rest;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import java.util.Map;

/**
 * {@link AbstractHttpDelegate}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/31
 */
public abstract class AbstractHttpDelegate extends HttpUtil {
  public HttpResponse postToResponse(String url, String data, Map<String, String> headers) {
    return HttpRequest.post(url).addHeaders(headers).body(data).execute();
  }

  public HttpResponse getToResponse(
      String url, Map<String, Object> paramMap, Map<String, String> headers) {
    return HttpRequest.get(url).addHeaders(headers).form(paramMap).execute();
  }
}
