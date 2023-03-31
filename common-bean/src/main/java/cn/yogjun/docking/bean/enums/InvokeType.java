package cn.yogjun.docking.bean.enums;

import lombok.Getter;

/**
 * {@link InvokeType}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/31
 */
@Getter
public enum InvokeType {
  REST("rest"),
  WSDL("wsdl"),
  FEIGN("feign"),
  METHOD("method"),
  SC("source-code"),
  ;
  private String type;

  InvokeType(String rest) {
  }
}
