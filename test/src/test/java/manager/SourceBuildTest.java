package manager;

import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.support.JsonSourceReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * {@link SourceBuildTest}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
public class SourceBuildTest {

  @Test
  public void build1() throws FileNotFoundException {
    FileReader fileReader =
        new FileReader(
            "/Users/miaojun/code/java/yog-docking/test/src/test/resources/demo-api-rest.json");
    SourceBean sourceBean = new JsonSourceReader().read(fileReader);
    System.out.println(sourceBean);
  }
}
