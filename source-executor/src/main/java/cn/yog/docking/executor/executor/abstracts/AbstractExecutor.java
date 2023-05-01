package cn.yog.docking.executor.executor.abstracts;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.yog.docking.executor.core.SourceExecutorFactory;
import cn.yog.docking.executor.param.Params;
import cn.yog.docking.executor.param.SourceContentHolder;
import cn.yogjun.docking.bean.constants.Constants;
import cn.yogjun.docking.source.manager.bean.base.SourceBean;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;

import java.util.Map;

/**
 * {@link AbstractExecutor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
public abstract class AbstractExecutor<T extends SourceSpec> implements SourceExecutor<T> {

  public AbstractExecutor() {}

  /** 资源执行 */
  protected abstract void sourceExecute(SourceBean<T> source, Params params);

  public void execute(SourceBean source, Params params) {
    this.doRequestParams(source, params);
    // 资源实际执行 todo 处理异步任务的场景
    this.sourceExecute(source, params);
    if (StrUtil.isNotBlank(source.getKey())) {
      SourceContentHolder.getCurrent().put(source.getKey(), params);
    }
    this.doResponseParams(source, params);
  }

  private void doRequestParams(SourceBean source, Params params) {
    for (Map.Entry<String, SourceBean> entry : source.getSpec().getRequestHandlers().entrySet()) {
      String parameter = entry.getKey();
      SourceBean s = entry.getValue();
      SourceExecutor se = SourceExecutorFactory.getExecutor(s);
      se.execute(s, params);
      if (StrUtil.equals(Constants.currentAlias, parameter)) {
        params = Params.ofMap(BeanUtil.beanToMap(params.getResponse()));
      } else {
        params.put(parameter, params.getResponse());
      }
    }
  }

  private void doResponseParams(SourceBean source, Params params) {
    Params responseParam = Params.ofMap(BeanUtil.beanToMap(params.getResponse()));
    for (Map.Entry<String, SourceBean> entry : source.getSpec().getResponseHandlers().entrySet()) {
      String parameter = entry.getKey();
      SourceBean s = entry.getValue();
      SourceExecutor se = SourceExecutorFactory.getExecutor(s);
      se.execute(s, responseParam);
      if (StrUtil.equals(Constants.currentAlias, parameter)) {
        params.setResponse(responseParam.getResponse());
      } else {
        responseParam.put(parameter, params.getResponse());
      }
    }
  }
}
