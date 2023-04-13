package cn.yogjun.docking.bean.exceptions;

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

  public ErrorSourceException(String message, String errorSource) {
    super(message);
    this.errorSource = errorSource;
  }
}
