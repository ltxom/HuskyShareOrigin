package com.huskyshare.backend.servlet;

import com.huskyshare.backend.hibernate.util.HibernateUtil;
import com.huskyshare.backend.model.user.User;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet
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
		try {
			//获取Session
			session = HibernateUtil.getSessionFactory().openSession();
			//开启事务
			session.beginTransaction();
			//查询ID为1的用户
			User user = (User) session.get(User.class, 1);
			//输出药品信息
			response.setCharacterEncoding("GBK");
			PrintWriter out = response.getWriter();
			out.println("ID：" + user.getId() + "<br>");
			out.println("用户名：" + user.getUsername() + "<br>");
			out.println("Email：" + user.getEmail() + "<br>");
			out.println("姓名：" + user.getFirstName() +" "+user.getLastName()+ "<br>");
			out.println("电话：" + user.getMobile() + "<br>");

			out.flush();
			out.close();
			//提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//出错将回滚事务
			session.getTransaction().rollback();
		} finally {
			//关闭Session对象
			HibernateUtil.shutdown();
		}
	}

}
