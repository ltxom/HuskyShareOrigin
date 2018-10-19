package com.huskyshare.backend.spring.test;

import com.huskyshare.backend.model.user.User;
import com.huskyshare.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

// Spring单元测试
@RunWith(BlockJUnit4ClassRunner.class)
public class SpringUnitTest extends UnitTestBase {


	public SpringUnitTest() {
		super("classpath*:resources/spring/applicationContext.xml");
	}

	@Test
	public void testUser() {//Spring IoC
		User user = super.getBean("userContructedBySpringSpEL");
		System.out.println(user.getId() + ": " + user.getUsername());
	}

	@Test
	public void testUserApplicationContext() {
		System.out.println(this.getClass().toString() + ": " + super.getBean("userContructedBySpring").hashCode());
	}

	@Test
	public void test3t() {
		UnitTestBase unitTestBase = new UnitTestBase("classpath*:spring/applicationContext.xml");
		UserService userService = unitTestBase.getBean("userService");
		User user = new User();
		user.setUsername("lko");

		userService.register(user);
	}
}