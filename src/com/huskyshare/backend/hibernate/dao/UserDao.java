package com.huskyshare.backend.hibernate.dao;

import com.huskyshare.backend.model.user.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class UserDao{

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Integer find(User user){
		hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
		List<User> users = (List<User>)this.getHibernateTemplate().find("from User u where u.username=\'"+user.getUsername()+"\'");
		if(users.size()==1)
			return users.get(0).getId();
		else if(users.size()==0)
			return -1;
		else
			throw new IllegalStateException("Found duplicated user");

	}

	public void save(User user){
		this.getHibernateTemplate().save(user);
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
	}
}
