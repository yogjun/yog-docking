package invoke;

import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.api.ApiRestSource;
import org.junit.Test;

/**
 * {@link ParamsTest}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/13
 */
public class ParamsTest {

  @Test
  public void testParams() {
    Params params = new Params();
    params.put(ApiRestSource::getUrl, 1);
    System.out.println(params);
    //
    //    System.out.println(params.get(ApiRestSource::getUrl));
    //    Params params2 = new Params();
    //    params2.put(ApiRestSource::getUrl, 1);
    //    System.out.println(params2);
  }
}
