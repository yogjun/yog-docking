package cn.yogjun.docking.function.manager.bean.api;

import cn.yogjun.docking.function.manager.bean.info.SourceBean;
import cn.yogjun.docking.function.manager.bean.info.SourceSpec;
import lombok.Data;

import java.util.LinkedHashMap;

/**
 * {@link ApiRestSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
public class ApiRestSource extends SourceSpec {
  /** http method */
  private String method;

  /** url */
  private String url;

  /** json/xml */
  private String dataType;

  /** 请求参数 */
  private LinkedHashMap<String, SourceBean> request;

  private LinkedHashMap<String, SourceBean> response;
}
