package cn.yogjun.docking.invoke.handler.method;

import cn.hutool.extra.spring.SpringUtil;
import cn.yogjun.docking.source.manager.resource.Resource;

@Component
public class SpringMethodUtil {

  /**
   * 根据 服务名称 ，方法名 反射调用 spring bean 中的 方法
   *
   * @param serviceName 服务名
   * @param methodName 方法名
   * @param params 参数
   * @return
   * @throws Exception
   */
  public static Object springInvokeMethod(String serviceName, String methodName, Object... params) {
    Object service = SpringUtil.getBean(serviceName);
    return MethodUtil.invokeMethod(service, methodName, params);
  }
}
