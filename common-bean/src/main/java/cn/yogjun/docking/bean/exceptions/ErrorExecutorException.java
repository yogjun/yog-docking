package cn.yogjun.docking.bean.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link ErrorExecutorException}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/21
 */
@Getter
public class ErrorExecutorException extends RuntimeException {
  private String errorExecutor;

  public ErrorExecutorException(Code code, String errorExecutor) {
    super(code.getMessage());
    this.errorExecutor = errorExecutor;
  }

  @Getter
  @AllArgsConstructor
  public enum Code {
    NOT_FOUND(500, "执行器未找到"),
    ;

    private Integer code;
    private String message;
  }
}
