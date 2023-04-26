package cn.yog.docking.executor.param;

/**
 * {@link SourceContentHolder}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
public class SourceContentHolder {
  private SourceContentHolder() {}

  private static final ThreadLocal<SourceContent> tl = new ThreadLocal<>();

  public static SourceContent getCurrent() {
    SourceContent sc = tl.get();
    if (null == sc) {
      setCurrent(new SourceContent());
    }
    return tl.get();
  }

  public static void removeCurrent() {
    tl.remove();
  }

  public static void setCurrent(SourceContent sc) {
    if (sc != null) {
      tl.set(sc);
    }
  }
}
