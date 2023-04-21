package cn.yog.docking.executor.core;

import java.lang.annotation.*;

/**
 * {@link Executor}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Executor {

  String type();

  String notes() default "";
}
