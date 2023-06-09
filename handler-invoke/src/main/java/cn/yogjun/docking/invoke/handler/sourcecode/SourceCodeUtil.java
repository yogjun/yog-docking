package cn.yogjun.docking.invoke.handler.sourcecode;

import java.util.Map;

/**
 * {@link SourceCodeUtil}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/6
 */
public interface SourceCodeUtil {

  Object executeCode(String sourceCode, Map<String,Object> params);
}
