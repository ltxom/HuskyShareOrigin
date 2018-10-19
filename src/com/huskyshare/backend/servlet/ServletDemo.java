package com.huskyshare.backend.servlet;

import com.huskyshare.backend.hibernate.util.HibernateUtil;
import com.huskyshare.backend.model.user.User;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDemo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = null;            //声明Session对象

		//获取Session
		session = HibernateUtil.getSessionFactory().openSession();
		//开启事务
		session.beginTransaction();
		//查询ID为1的用户
		User user = (User) session.get(User.class, 1);
		//输出信息
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		out.println("ID：" + user.getId());
		out.println("用户名：" + user.getUsername());
		out.println("Email：" + user.getEmail());
		out.println("姓名：" + user.getFirstName() + " " + user.getLastName());
		out.println("电话：" + user.getMobile());

		// Spring IoC测试
		ApplicationContext factory = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
		User userFromSpring = (User) factory.getBean("userContructedBySpring");
		out.println("用户名：" + userFromSpring.getUsername());
		out.println("姓：" + userFromSpring.getLastName());
		out.println("名：" + userFromSpring.getFirstName());


		out.flush();
		out.close();


		//提交事务
		session.getTransaction().commit();
		session.close();
		//关闭Session对象
		//HibernateUtil.shutdown();

	}

}
