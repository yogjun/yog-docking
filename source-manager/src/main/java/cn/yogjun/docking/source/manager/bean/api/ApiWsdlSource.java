package cn.yogjun.docking.source.manager.bean.api;

import cn.hutool.core.util.StrUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import cn.yogjun.docking.source.manager.bean.base.SourceSpec;
import cn.yogjun.docking.source.manager.support.Resource;
import lombok.Data;

import java.util.Map;

/**
 * {@link ApiWsdlSource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/12
 */
@Data
@Resource(type = SourceTypeAlias.WSDL)
public class ApiWsdlSource extends SourceSpec {
  private String url;
  private String serviceClass;
  private Class<?> clazz;
  private String methodName;

  @Override
  public void checkSource() {
    if (!StrUtil.isAllNotBlank(this.getUrl(), this.getMethodName(), this.getServiceClass())) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
    // check class
    try {
      Class<?> clazz = Class.forName(this.getServiceClass());
      this.setClazz(clazz);
    } catch (ClassNotFoundException e) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  public SourceSpec buildSource(Map<String, Object> map) {
    ApiWsdlSource apiWsdlSource = new ApiWsdlSource();
    apiWsdlSource.setServiceClass((String) map.get("serviceClass"));
    apiWsdlSource.setUrl((String) map.get("url"));
    apiWsdlSource.setMethodName((String) map.get("methodName"));
    return apiWsdlSource;
  }
}
