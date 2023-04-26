package cn.yog.docking.executor.param;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link SourceContent} 全局上下文
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
public class SourceContent extends Params {

  /** super:设置参数处理（全局参数设置） */

  /**
   * key: 资源key
   *
   * <p>value: 对应资源执行时的参数
   */
  @Getter private Map<String, Params> paramsMap = new HashMap<>();
}
