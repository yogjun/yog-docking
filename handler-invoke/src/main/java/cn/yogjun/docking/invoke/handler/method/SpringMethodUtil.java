package cn.yogjun.docking.invoke.handler.method;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

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
    // 找到方法
    Method method =
        ReflectionUtils.findMethod(
            service.getClass(), methodName, MethodUtil.getParamClass(params));
    // 执行方法
    return ReflectionUtils.invokeMethod(method, service, params);
  }
}
