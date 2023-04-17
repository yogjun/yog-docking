package cn.yogjun.docking.invoke.handler.method;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link MethodUtil}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/6
 */
@Slf4j
public class MethodUtil {
  public MethodUtil() {}

  public static Object invokeMethod(String className, String methodName, Object... params) {
    Object t = null;
    try {
      Class clazz = Class.forName(className);
      Object obj = clazz.getDeclaredConstructor().newInstance();
      Method method = clazz.getMethod(methodName, getParamClass(params));
      t = method.invoke(obj, params);
    } catch (ClassNotFoundException
        | NoSuchMethodException
        | InstantiationException
        | IllegalAccessException
        | InvocationTargetException e) {
      log.error("invokeMethod error", e);
    }
    return t;
  }

  public static Object invokeMethod(
      Object obj, Class<?> clazz, String methodName, Object... params) {
    Object t = null;
    try {
      Method method = clazz.getMethod(methodName, getParamClass(params));
      t = method.invoke(obj, params);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      log.error("invokeMethod error", e);
    }
    return t;
  }

  public static Class<? extends Object>[] getParamClass(Object[] params) {
    Class<? extends Object>[] paramClass = null;
    if (params != null) {
      int paramsLength = params.length;
      paramClass = new Class[paramsLength];
      for (int i = 0; i < paramsLength; i++) {
        paramClass[i] = params[i].getClass();
      }
    }
    return paramClass;
  }
}
