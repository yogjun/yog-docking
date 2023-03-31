package cn.yogjun.docking.invoke.handler.rest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link RestKit}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/31
 */
public class RestKit {

  private static AbstractHttpDelegate delegate = new DefaultHttpKit();

  public static AbstractHttpDelegate getDelegate() {
    return delegate;
  }

  public static void setDelegate(AbstractHttpDelegate delegate) {
    RestKit.delegate = delegate;
  }

  public static String readData(HttpServletRequest request) {
    BufferedReader br = null;
    try {
      StringBuilder result = new StringBuilder();
      br = request.getReader();
      for (String line; (line = br.readLine()) != null; ) {
        if (result.length() > 0) {
          result.append("\n");
        }
        result.append(line);
      }
      return result.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 将同步通知的参数转化为Map
   *
   * @param request {@link HttpServletRequest}
   * @return 转化后的 Map
   */
  public static Map<String, String> toMap(HttpServletRequest request) {
    Map<String, String> params = new HashMap<>();
    Map<String, String[]> requestParams = request.getParameterMap();
    for (String name : requestParams.keySet()) {
      String[] values = requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      params.put(name, valueStr);
    }
    return params;
  }
}

class DefaultHttpKit extends AbstractHttpDelegate {}
