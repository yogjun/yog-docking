package cn.yogjun.docking.source.manager.bean.api;

import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import lombok.Data;

/**
 * {@link ApiWsdlSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class ApiWsdlSource extends SourceSpec {
  private String url;
  private String serviceClass;
  private String methodName;
}
