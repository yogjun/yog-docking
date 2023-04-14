package cn.yogjun.docking.source.manager.bean.base;

import lombok.Data;

import java.util.LinkedHashMap;

/**
 * {@link SourceSpec}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class SourceSpec {

  /** 当出现多个的时候表示顺序 */
  private int order;
  /** 请求参数处理 */
  private LinkedHashMap<String, Sourcebean> request;
  /** 返回参数处理 */
  private LinkedHashMap<String, Sourcebean> response;
}
