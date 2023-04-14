package cn.yogjun.docking.source.manager.bean.function;

import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import lombok.Data;

/**
 * {@link FunctionJavaSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class FunctionJavaSource extends SourceSpec {

  private String className;
  private String methodName;
}
