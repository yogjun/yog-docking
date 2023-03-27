package cn.yogjun.docking.enums;

/**
 * {@link ContentType}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/27
 */
public enum ContentType {
  /** json格式 */
  JSON("json", String.class),
  /** xml格式 */
  XML("xml", String.class),
  /** java的bean结构 */
  BEAN("java-bean", Object.class),
  ;

  private String desc;
  private Class clazz;

  ContentType(String desc, Class clazz) {
    this.desc = desc;
    this.clazz = clazz;
  }

  public String getDesc() {
    return desc;
  }

  public Class getClazz() {
    return clazz;
  }
}
