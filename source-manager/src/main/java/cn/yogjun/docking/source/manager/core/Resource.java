package cn.yogjun.docking.source.manager.core;

import java.lang.annotation.*;

/**
 * {@link Resource}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/19
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resource {
  String type();

  String notes() default "";
}
