package cn.yogjun.docking.source.manager.bean.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link SourceMetaBean}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SourceMetaBean {

  private String remark;
  private String name;
  private String group;
}
