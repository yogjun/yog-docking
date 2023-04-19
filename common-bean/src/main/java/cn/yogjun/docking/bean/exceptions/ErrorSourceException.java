package cn.yogjun.docking.bean.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link ErrorSourceException}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
@Getter
public class ErrorSourceException extends RuntimeException {
  private String errorSource;

  public ErrorSourceException(Code code, String errorSource) {
    super(code.getMessage());
    this.errorSource = errorSource;
  }

  @Getter
  @AllArgsConstructor
  public enum Code {
    SOURCE_FORMAT_ERROR(500, "资源格式错误"),
    NOT_FOUND(404, "资源未找到"),
    ;

    private Integer code;
    private String message;
  }
}
