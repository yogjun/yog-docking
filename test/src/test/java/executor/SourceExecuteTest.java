package executor;

import cn.yog.docking.executor.executor.SourceExecutor;
import cn.yog.docking.executor.executor.SourceExecutorFactory;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.base.RootSourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.support.JsonSourceReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * {@link SourceExecuteTest}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
public class SourceExecuteTest {

  @Test
  public void test1() throws FileNotFoundException {
    FileReader fileReader =
            new FileReader(
                    "/Users/miaojun/code/java/yog-docking/test/src/test/resources/demo-api-rest2.json");
    RootSourceBean sourceBean = new JsonSourceReader().read(fileReader);
    System.out.println(sourceBean);

    Params p = new Params();

    SourceExecutor se = SourceExecutorFactory.getExecutor(sourceBean);
    se.execute(sourceBean,p );
    System.out.println(p);
  }
}
