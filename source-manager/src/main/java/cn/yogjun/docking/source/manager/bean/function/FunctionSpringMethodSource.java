package cn.yogjun.docking.source.manager.bean.function;

import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import lombok.Data;

/**
 * {@link FunctionSpringMethodSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class FunctionSpringMethodSource extends SourceSpec {

  private String beanId;
  private String methodName;
}
