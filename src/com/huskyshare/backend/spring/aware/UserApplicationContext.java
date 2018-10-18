package com.huskyshare.backend.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 这个例子展示了如果想从Spring中ApplicationContext得到Bean的方法
 * */
public class UserApplicationContext implements ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(this.getClass().toString()+": "+applicationContext.getBean("userContructedBySpring").hashCode());
	}
}
