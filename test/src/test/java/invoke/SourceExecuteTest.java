package invoke;

import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.executor.SourceExecutorFactory;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import org.junit.Test;

/**
 * {@link SourceExecuteTest}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/17
 */
public class SourceExecuteTest {
//  @Test
  public void testWsdl() {
    // 1.读取source(比如根据id获取资源)
    SourceBean sourceBean = null;
    SourceExecutor se = SourceExecutorFactory.getExecutor(sourceBean);
    se.execute(sourceBean, null);
  }
}
