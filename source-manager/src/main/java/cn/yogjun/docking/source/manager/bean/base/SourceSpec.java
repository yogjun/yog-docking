package cn.yogjun.docking.source.manager.bean.base;

import cn.hutool.core.collection.CollUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.source.manager.core.SourceBuilderFactory;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * {@link SourceSpec}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public abstract class SourceSpec implements SourceHandle {
  /** 请求参数处理 */
  private Map<String, SourceBean> requestHandlers = Maps.newLinkedHashMap();
  /** 返回参数处理 */
  private Map<String, SourceBean> responseHandlers = Maps.newLinkedHashMap();

  protected abstract SourceSpec buildSource(Map<String, Object> map);

  @Override
  public SourceSpec build(Map<String, Object> map) {
    SourceSpec ss = buildSource(map);
    ss.buildRequests(map);
    ss.buildResponses(map);
    ss.checkSource();
    return ss;
  }

  private void buildRequests(Map<String, Object> map) {
    Map<String, Map<String, Object>> requestBean =
        (Map<String, Map<String, Object>>) map.get("request");
    if (CollUtil.isEmpty(requestBean)) {
      return;
    }
    requestBean.forEach(
        (k, v) ->
            requestHandlers.put(
                k,
                (SourceBean)
                    SourceBuilderFactory.getSourceHandleBuilder(SourceTypeAlias.PUBLIC).build(v)));
  }

  private void buildResponses(Map<String, Object> map) {
    Map<String, Map<String, Object>> requestBean =
        (Map<String, Map<String, Object>>) map.get("response");
    if (CollUtil.isEmpty(requestBean)) {
      return;
    }
    requestBean.forEach(
        (k, v) ->
            responseHandlers.put(
                k,
                (SourceBean)
                    SourceBuilderFactory.getSourceHandleBuilder(SourceTypeAlias.PUBLIC).build(v)));
  }
}
