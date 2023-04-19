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
public abstract class SourceSpec implements SourceHandle {
  /** 请求参数处理 */
  private LinkedHashMap<String, SourceBean> requestHandlers;
  /** 返回参数处理 */
  private LinkedHashMap<String, SourceBean> responseHandlers;
}
