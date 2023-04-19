package cn.yogjun.docking.bean.constants;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * {@link SourceTypeAlias} 资源类型常量
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
public interface SourceTypeAlias {
  /** 公共资源 */
  String PUBLIC = "public";
  /** api */
  String REST = "api-rest";

  String WSDL = "api-wsdl";

  /** 函数调用 */
  String METHOD_FUNCTION = "function-method";

  String METHOD_SPRING_FUNCTION = "function-method-spring";

  /** processor */
  String PROCESSOR_REFERENCE = "processor-reference";

  String PROCESSOR_COMPOSITION = "processor-composition";

  /** property */
  String PROPERTY_INTEGER = "property-integer";

  String PROPERTY_STRING = "property-string";

  /** 所有可用类型字段 */
  Set<String> sourceTypes =
      Sets.newHashSet(
          REST,
          WSDL,
          METHOD_FUNCTION,
          METHOD_SPRING_FUNCTION,
          PROPERTY_INTEGER,
          PROCESSOR_REFERENCE,
          PROCESSOR_COMPOSITION);
}
