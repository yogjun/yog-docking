package cn.yogjun.docking.bean.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link ApiRestErrorException}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
@Getter
public class ApiRestErrorException extends RuntimeException {
  private String errorSource;

  public ApiRestErrorException(Code code, String errorSource) {
    super(code.getMessage());
    this.errorSource = errorSource;
  }

  @Getter
  @AllArgsConstructor
  public enum Code {
    UNSUPPORT_METHOD(500, "不支持当前方法"),
    ;

    private Integer code;
    private String message;
  }
}
