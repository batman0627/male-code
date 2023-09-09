package com.male.basic.aop;

import com.male.basic.annotation.TakeTime;
import com.male.basic.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 详细描述: StopWatchMethod注解拦截
 * <p>
 * 1. AOP名词基础概念
 * 切面（Aspect）
 * AOP思想就是面向切面编程，对一个我们已经封装好的类，我们可以在运行的各个时期，
 * 对其进行切割，在原有的方法中织入一些新的代码，不改变原有方法的功能，只做增强，
 * 而那些增强部分的代码，就被称为切面。常常用于权限认证，日志，事务处理等。
 * 切入点（PointCut）
 * 所谓切入点，就是那个类中的那个方法进行增强，进行切割，指被增强的方法，就是要切
 * 的东西。
 * 连接点（JoinPoint）
 * 在我们知道要切入那些方法之后，就需要知道在什么时候切入，比如在方法被调用之前，
 * 调用之后，发生异常等时候调用。
 * 通知（advice）
 * 所谓的通知，就是通知被织入的方法，应该如何增强。其中@Pointcut注解为指明切入点，
 *
 * @author MingFangXu
 * @Before,@After 是连接点，注解对应下面的就是对应的通知。
 * 目标对象（Target Object）
 * 被一个或者多个切面通知的对象，就是目标对象。
 * 织入（Weaving）
 * 所谓织入，就是将切面切入到目标方法中，使得目标方法被增强的过程。
 * <p>
 * 2. 常用注解解释
 * @Aspect: 作用是把当前类标识为一个切面供容器读取。
 * @Pointcut： 是声明切入点，Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
 * @Around：环绕增强，相当于MethodInterceptor
 * @AfterReturning：后置增强，方法执行之后再执行，相当于AfterReturningAdvice方法正常退出时执行
 * @Before：前置增强方法，方法执行之前执行，相当于BeforeAdvice的功能，相似功能的还有
 * @AfterThrowing：异常抛出增强，相当于ThrowsAdvice
 * @After: 最终通知（在目标方法执行后调用，无论目标方法是否出现异常，都会执行）,不管是抛出异常或者正常退出都会执行
 * </p>
 */
@Slf4j
@Aspect
@Component
public class TakeTimeAspect {

	private final AppProperties appProperties;

	public TakeTimeAspect(AppProperties appProperties) {
		this.appProperties = appProperties;
	}

	@Pointcut("@annotation(com.male.basic.annotation.TakeTime)")
	public void stopWatchMethodPointcut() {
	}

	@Around("stopWatchMethodPointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		// 获取目标方法所属类的类名
		String classFullName = signature.getDeclaringTypeName();
		// 获取目标方法所属类的简单类名
		//String className = signature.getDeclaringType().getSimpleName();
		// 获取方法上的注解
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		TakeTime annotation = method.getAnnotation(TakeTime.class);
		String taskName = method.getName();
		if (StringUtils.hasText(annotation.caption())) {
			taskName = annotation.caption();
		}
		String id = classFullName + "#" + method.getName();
		StopWatchExt stopWatch = new StopWatchExt(id);
		stopWatch.start(taskName);
		Object object = joinPoint.proceed();
		stopWatch.stop();
		stopWatch.print(log,annotation.timeUnit(),appProperties.isStopWatchLogEnabled());
		return object;
	}
}