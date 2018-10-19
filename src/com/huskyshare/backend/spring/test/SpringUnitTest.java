package com.huskyshare.backend.spring.test;

import com.huskyshare.backend.model.user.User;
import com.huskyshare.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Scanner;

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
		UserService userService = super.getBean("userService");

		User user = new User();
		Scanner in = new Scanner("a\nb\nc\nd\ne@email.com\n111");
		System.out.println("Please enter your user name:");
		String userName = in.nextLine();
		System.out.println("Please enter your password:");
		String password = in.nextLine();
		System.out.println("Please enter your last name:");
		String lastName = in.nextLine();
		System.out.println("Please enter your first name:");
		String firstName = in.nextLine();
		System.out.println("Please enter your email:");
		String email = in.nextLine();
		System.out.println("Please enter your mobile:");
		String mobile = in.nextLine();

		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setMobile(mobile);

		userService.register(user);
	}
}