package cn.yogjun.docking.source.manager.bean.base;

import cn.hutool.core.util.StrUtil;
import cn.yogjun.docking.bean.constants.SourceTypeAlias;
import cn.yogjun.docking.bean.exceptions.ErrorSourceException;
import lombok.Data;

/**
 * {@link RootSourceBean}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
@Data
public class RootSourceBean extends SourceBean {
  @Override
  public void checkSource() {
    // 校验类型和id不能为空
    // 规格参数不能为空
    if (!StrUtil.isAllNotBlank(this.getId(), this.getType())
        || null == getSpec()
        || !SourceTypeAlias.sourceTypes.contains(getType())) {
      throw new ErrorSourceException(
          ErrorSourceException.Code.SOURCE_FORMAT_ERROR, this.toString());
    }
  }

  @Override
  protected SourceBean getInstance(){
    return new RootSourceBean();
  }
}
