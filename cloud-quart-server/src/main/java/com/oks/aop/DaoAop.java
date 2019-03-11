package com.oks.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.oks.annotation.Loacl;
import com.oks.annotation.Master;
import com.oks.annotation.Slave;
import com.oks.dao.split.DynamicDataSourceHolder;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源选举AOP
 * 
 * @author happy everyday
 *
 */
@Aspect
@Component
@Slf4j
public class DaoAop {

	@Pointcut(value = "execution( public * com.oks.mapper..*(..))")
	public void daoCut() {
	}

	@Before(value = "daoCut()")
	public void before(JoinPoint joinPoint) {
		
		String name = joinPoint.getSignature().getName();
		Class<?> declaringType = joinPoint.getSignature().getDeclaringType();
		Method[] methods = declaringType.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(name)) {
				Annotation annotation = method.getAnnotations()[0];
				if (annotation instanceof Slave) {
					DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_SLAVE);
				} else if(annotation instanceof Master){
					DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_MASTER);
				}else if(annotation instanceof Loacl) {
					DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_LOCAL);
				}
			}

		}
	}

	@After(value = "daoCut()")
	public void after() {
		log.info("方法执行完毕,释放线程变量");
		DynamicDataSourceHolder.cleanDbType();
	}

}
