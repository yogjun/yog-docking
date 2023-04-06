package cn.yogjun.docking.invoke.handler.feign.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link IFeignClient}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/6
 */
@Component
public class IFeignClient {
  @Autowired private IFeignClientFactory<IFeign> iFeignClientFactory;

  public Object executePostApi(String feignName, String url, Object params) {
    IFeign iFeign = iFeignClientFactory.getFeignClient(IFeign.class, feignName);
    return iFeign.executePostApi(url, params);
  }

  public Object executeGetApi(String feignName, String url, Object params) {
    IFeign iFeign = iFeignClientFactory.getFeignClient(IFeign.class, feignName);
    return iFeign.executeGetApi(url, params);
  }
}
