package cn.yogjun.docking.invoke.handler.method;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class SpringMethodUtil implements ApplicationContextAware {
  /** Spring容器 spring应用上下文对象 */
  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringMethodUtil.applicationContext = applicationContext;
  }

  /**
   * 对象名称获取spring bean对象
   *
   * @param name
   * @return
   * @throws BeansException
   */
  public static Object getBean(String name) throws BeansException {
    return applicationContext.getBean(name);
  }

  /**
   * 根据 服务名称 ，方法名 反射调用 spring bean 中的 方法
   *
   * @param serviceName 服务名
   * @param methodName 方法名
   * @param params 参数
   * @return
   * @throws Exception
   */
  public static Object springInvokeMethod(String serviceName, String methodName, Object[] params)
      throws Exception {
    Object service = getBean(serviceName);

    // 找到方法
    Method method =
        ReflectionUtils.findMethod(
            service.getClass(), methodName, MethodUtil.getParamClass(params));
    // 执行方法
    return ReflectionUtils.invokeMethod(method, service, params);
  }
}
