package cn.yogjun.docking.function.manager.bean.function;

import cn.yogjun.docking.function.manager.bean.base.SourceSpec;
import lombok.Data;

/**
 * {@link FunctionJavaSpringSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class FunctionJavaSpringSource extends SourceSpec {

  private String beanId;
  private String methodName;
}
