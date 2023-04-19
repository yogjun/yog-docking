package cn.yogjun.docking.source.manager.support;

import cn.yogjun.docking.source.manager.bean.base.RootSourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;

import java.io.Reader;

/**
 * {@link SourceReader}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public interface SourceReader {
  RootSourceBean read(Reader reader) throws Exception;
}
