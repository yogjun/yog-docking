package cn.yog.docking.executor.param;

import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.func.LambdaUtil;
import lombok.ToString;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * {@link Params} 执行器使用参数
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
@ToString
public class Params implements Iterable<Entry<String, Object>> {

  /** 参数 */
  private Map<String, Object> params = new LinkedHashMap<>();
  /** 处理结果 */
  private Object response;

  public void put(String name, Object param) {
    Objects.requireNonNull(name);
    this.params.put(name, param);
  }

  public <T, R> void put(Func1<T, R> nameFunc, Object param) {
    this.put(LambdaUtil.getFieldName(nameFunc), param);
  }

  public Object get(String name) {
    Objects.requireNonNull(name);
    return this.params.get(name);
  }

  public <T, R> Object get(Func1<T, R> nameFunc) {
    return this.get(LambdaUtil.getFieldName(nameFunc));
  }

  public Object remove(String name) {
    Objects.requireNonNull(name);
    return this.params.remove(name);
  }

  public <T, R> Object remove(Func1<T, R> nameFunc) {
    return this.remove(LambdaUtil.getFieldName(nameFunc));
  }

  public Map<String, Object> asMap() {
    return this.params;
  }

  public List<Object> asList() {
    return this.params.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
  }

  @Override
  public Iterator<Entry<String, Object>> iterator() {
    return this.params.entrySet().iterator();
  }

  public Object getResponse() {
    return response;
  }

  public void setResponse(Object response) {
    this.response = response;
  }

  public String toJson() {
    return "";
  }
}
