package cn.yogjun.docking.invoke.handler.feign.client;

import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * {@link IFeignClientFactory}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/6
 */
@Component
public class IFeignClientFactory<T> {
  private FeignClientBuilder feignClientBuilder;

  public IFeignClientFactory(ApplicationContext appContext) {
    this.feignClientBuilder = new FeignClientBuilder(appContext);
  }

  public T getFeignClient(final Class<T> type, String serviceId) {
    return this.feignClientBuilder.forType(type, serviceId).build();
  }
}
