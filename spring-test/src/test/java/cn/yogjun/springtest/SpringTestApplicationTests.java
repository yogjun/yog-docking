package cn.yogjun.springtest;

import cn.yog.docking.executor.executor.abstracts.SourceExecutor;
import cn.yog.docking.executor.core.SourceExecutorFactory;
import cn.yog.docking.executor.param.Params;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.support.file.JsonSourceReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileReader;

@SpringBootTest
class SpringTestApplicationTests {

  @Test
  void contextLoads() throws FileNotFoundException {
    FileReader fileReader =
        new FileReader(
            "/Users/miaojun/code/java/yog-docking/spring-test/src/test/resources/demo-api-rest2.json");
    SourceBean sourceBean = new JsonSourceReader().read(fileReader);
    System.out.println(sourceBean);

    Params p = new Params();

    SourceExecutor se = SourceExecutorFactory.getExecutor(sourceBean);
    se.execute(sourceBean, p);
    System.out.println(p);
  }
}
