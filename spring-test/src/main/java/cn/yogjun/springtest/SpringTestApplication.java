package cn.yogjun.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(@ComponentScan(basePackages = {"cn.yog.docking.executor.executor"}))
public class SpringTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringTestApplication.class, args);
  }
}
