package cn.yogjun.docking.source.manager.bean.base;

import lombok.Data;

/**
 * {@link Sourcebean}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/11
 */
@Data
public class Sourcebean<T extends SourceSpec> extends SourceSpec {

  /** id type-group-name,example: "api-rest-ccc-d" */
  private String id;

  private int version;

  /** api-rest */
  private String type;

  private SourceMetaBean metadata;
  private T spec;
}
