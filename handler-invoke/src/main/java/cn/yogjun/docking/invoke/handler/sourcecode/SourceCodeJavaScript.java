package cn.yogjun.docking.invoke.handler.sourcecode;

import lombok.extern.slf4j.Slf4j;

import javax.script.*;
import java.util.Map;

/**
 * {@link SourceCodeJavaScript}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/10
 */
@Slf4j
public class SourceCodeJavaScript implements SourceCodeUtil {
  @Override
  public Object executeCode(String sourceCode, Map<String, Object> params) {
    try {

      ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
      Compilable compilable = (Compilable) engine;
      Bindings bindings = engine.createBindings(); // Local级别的Binding
      String script = sourceCode; // 定义函数并调用
      CompiledScript JSFunction = compilable.compile(script); // 解析编译脚本函数
      // 通过Bindings加入参数
      bindings.putAll(params);
      Object result = JSFunction.eval(bindings);
      return result;
    } catch (ScriptException e) {
      throw new RuntimeException(e);
    }
  }
}
