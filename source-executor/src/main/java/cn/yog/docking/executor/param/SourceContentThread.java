package cn.yog.docking.executor.param;

/**
 * {@link SourceContentThread}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
public class SourceContentThread {
  private SourceContentThread() {}

  private static final ThreadLocal<SourceContent> tl = new ThreadLocal<>();

  public static SourceContent getCurrentUser() {
    return tl.get();
  }

  public static void removeCurrentUser() {
    tl.remove();
  }

  public static void setCurrentUser(SourceContent sc) {
    if (sc != null) {
      tl.set(sc);
    }
  }
}
