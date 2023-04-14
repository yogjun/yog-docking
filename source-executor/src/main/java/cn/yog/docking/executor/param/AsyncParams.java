package cn.yog.docking.executor.param;

/**
 * {@link AsyncParams}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/14
 */
public class AsyncParams extends Params {
  private SourceContent sourceContent;

  public SourceContent getSourceContent() {
    return sourceContent;
  }

  public void setSourceContent(SourceContent sourceContent) {
    this.sourceContent = sourceContent;
  }
}
