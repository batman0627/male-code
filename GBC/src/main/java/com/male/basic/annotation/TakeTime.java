package com.male.basic.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 详细描述: TakeTime 方法耗时监控注解
 * </p>
 *
 * @author MingFangXu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// @Indexed注解的引入正是为了解决@ComponentScan扫描的package包含的类越来越多的时候，
// Spring启动时模式注解解析时间就会变得越长的问题。
// 项目编译打包时，会在自动生成META-INF/spring.components文件，文件包含被
// @Indexed注释的类的模式解析结果。当Spring应用上下文进行组件扫描时，
// META-INF/spring.components会被
// org.springframework.context.index.CandidateComponentsIndexLoader读取并加载，
// 转换为CandidateComponentsIndex对象，此时组件扫描会读取CandidateComponentsIndex，
// 而不进行实际扫描，从而提高组件扫描效率，减少应用启动时间。
@Indexed
public @interface TakeTime {
	/**
	 * 监控的方法描述
	 *
	 * @return
	 */
	String caption() default "";

	/**
	 * 监控的方法描述
	 *
	 * @return
	 */
	TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
