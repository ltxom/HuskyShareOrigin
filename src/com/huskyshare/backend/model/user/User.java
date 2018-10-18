package com.huskyshare.backend.model.user;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

public class User implements Serializable, InitializingBean, DisposableBean, BeanNameAware {
	// 编号
	private Integer id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// email
	private String email;
	// First Name
	private String firstName;
	// Last Name
	private String lastName;
	// Last Name
	private String mobile;

	private String beanName;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Spring初始化用户中……");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Spring结束用户");
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("Spring配置文件定义的bean name：" + beanName);
	}

}
