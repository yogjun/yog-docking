package cn.yogjun.docking.source.manager.bean.base;

import java.util.Map;

/**
 * {@link SourceHandle}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/18
 */
public interface SourceHandle {

  /** 检查资源 */
  void checkSource();

  SourceSpec build(Map<String, Object> map);
}
