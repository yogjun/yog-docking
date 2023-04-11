package cn.yogjun.docking.invoke.handler.feign;

import cn.hutool.extra.spring.SpringUtil;
import cn.yogjun.docking.invoke.handler.feign.client.IFeignClient;

/**
 * {@link SpringFeignClientUtil}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/6
 */
public class SpringFeignClientUtil {

  public static Object invokeFeignClient(
      String httpMethod, String feignName, String url, Object param) throws Exception {
    IFeignClient iFeignClient = SpringUtil.getBean(IFeignClient.class);
    switch (httpMethod) {
      case "GET":
        return iFeignClient.executeGetApi(feignName, url, param);
      case "POST":
        return iFeignClient.executePostApi(feignName, url, param);
      default:
        throw new Exception("unsupport such method");
    }
  }
}
