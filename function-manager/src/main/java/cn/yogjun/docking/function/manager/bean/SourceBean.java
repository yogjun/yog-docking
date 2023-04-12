package cn.yogjun.docking.function.manager.bean;

import lombok.Data;

/**
 * {@link SourceBean}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
@Data
public class SourceBean {

  /** id example: "api-rest-ccc-d" */
  private String id;
  private int version;
  private String type;
  private String subType;
  private String group;
  private String name;
  private SourceMetaBean metadata;
}
