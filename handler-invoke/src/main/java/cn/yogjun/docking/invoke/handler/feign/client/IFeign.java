package cn.yogjun.docking.invoke.handler.feign.client;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * {@link IFeign}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/6
 */
public interface IFeign {

  @PostMapping("{url}")
  Object executePostApi(@PathVariable("url") String url, @RequestBody Object params);

  @GetMapping("{url}")
  Object executeGetApi(@PathVariable("url") String url, @SpringQueryMap Object params);
}
