package com.huskyshare.backend.hibernate.test;

import com.huskyshare.backend.hibernate.util.HibernateUtil;
import com.huskyshare.backend.model.user.User;
import org.hibernate.Session;
import org.junit.Test;

import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class HibernateUnitTest {

	@Test
	// 测试Hibernate基本连接
	public void test1() {
		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		session.beginTransaction();
		//查询ID为1的用户
		User user1 = session.get(User.class, 1);

		// User user1 = session.load(User.class, 1); // load方法延迟加载代理对象
		//输出信息
		out.println("ID：" + user1.getId());
		out.println("用户名：" + user1.getUsername());
		out.println("Email：" + user1.getEmail());
		out.println("姓名：" + user1.getFirstName() + " " + user1.getLastName());
		out.println("电话：" + user1.getMobile());

		//提交事务
		session.getTransaction().commit();
		session.close();
		//关闭Session对象
		//HibernateUtil.shutdown();
	}

	@Test
	// 测试Hibernate更新内容
	public void test2() {
		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		session.beginTransaction();
		User user1 = session.get(User.class, 1);
		user1.setPassword(System.currentTimeMillis() + "");

		User user2 = session.get(User.class, 2);
		if (user2 == null) {
			user2 = new User();
			user2.setId(2);
			user2.setUsername("dylan");
			user2.setPassword(System.currentTimeMillis() + "");
			user2.setEmail("dylan@uw.edu");
			user2.setLastName("Li");
			user2.setFirstName("Yuanhao");
		}

		session.save(user2);
		session.saveOrUpdate(user1);//因为已指定id->更新

		//提交事务
		session.getTransaction().commit();
		session.close();
		//关闭Session对象
		//HibernateUtil.shutdown();
	}

	@Test
	// 测试Hibernate查询
	public void test3() {
		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		session.beginTransaction();

		Query query = session.createQuery("from User");
		List<User> listOfUsers = query.list();
		for (User user : listOfUsers) {
			if (user.getEmail().endsWith("@uw.edu")) {
				System.out.println(user.getUsername());
			}
		}

		//提交事务
		session.getTransaction().commit();
		session.close();
		//关闭Session对象
		HibernateUtil.shutdown();
	}

	@Test
	// 模拟用户注册
	public void test4() {
		Scanner in = new Scanner("testUser\ntestPassword\ntestLastName\ntestFirstName\ntest@email.com\ntestNum");
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

		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		session.beginTransaction();

		User user = new User();

		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setMobile(mobile);

		session.save(user);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
	}

	@Test
	// 测试HQL Hibernate查询 w/ 线程session
	public void test5() {
		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		//开启事务
		session.beginTransaction();

		Query query = session.createQuery("from User where email like ?1");
		query.setParameter(1, "%@uw.edu");
		List<User> listOfUsers = query.list();
		for (User user : listOfUsers) {
			System.out.println(user.getUsername());
		}


		//提交事务，无需关闭session对象
		session.getTransaction().commit();

		//关闭Session对象
		HibernateUtil.shutdown();
	}

	@Test
	// 测试QBC Hibernate查询 w/ 线程session
	public void test6() {
		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		//开启事务
		session.beginTransaction();

		CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
		criteriaQuery.from(User.class);
		List<User> listOfUsers = session.createQuery(criteriaQuery).getResultList();
		for (User user : listOfUsers) {
			if (user.getEmail().endsWith("@uw.edu")) {
				System.out.println(user.getUsername());
			}
		}



		//提交事务，无需关闭session对象
		session.getTransaction().commit();

		//关闭Session对象
		HibernateUtil.shutdown();
	}
}
