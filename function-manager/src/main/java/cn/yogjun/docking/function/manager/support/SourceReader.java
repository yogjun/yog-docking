package cn.yogjun.docking.function.manager.support;

import cn.yogjun.docking.function.manager.bean.base.Source;

import java.io.Reader;

/**
 * {@link SourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public interface SourceReader {
  // todo reader impl
  Source read(Reader reader) throws Exception;
}
