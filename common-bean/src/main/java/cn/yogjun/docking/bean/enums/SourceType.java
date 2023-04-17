package cn.yogjun.docking.bean.enums;

import cn.yogjun.docking.bean.constants.SourceExecutorAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link SourceType}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/27
 */
@Getter
@AllArgsConstructor
public enum SourceType {
  /** API */
  REST("rest调用", SourceExecutorAlias.REST),
  WSDL("wsdl", SourceExecutorAlias.WSDL),
  /** JAVA FUNCTION */
  JAVA_FUNCTION("java函数", SourceExecutorAlias.METHOD_FUNCTION),
  JAVA_SPRING_FUNCTION("java函数", SourceExecutorAlias.METHOD_SPRING_FUNCTION),
  /** property */
  INTEGER("int字段处理", ""),
  STRING("string字段处理", ""),
  ARRAY("数组字段处理", ""),
  /** processor */
  REFERENCE("嵌套", ""),
  COMPOSITION("组合处理", ""),
  ;

  private String desc;
  private String handlerName;
}
