package com.huskyshare.backend.hibernate.dao;

import com.huskyshare.backend.model.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;


public class UserDao extends HibernateDaoSupport{
	public Integer find(User user){
		List<User> users = (List<User>)this.getHibernateTemplate().find("from User u where u.username=?",user.getUsername());
		if(users.size()==1)
			return users.get(0).getId();
		else if(users.size()==0)
			return -1;
		else
			throw new IllegalStateException("Found duplicated user");

	}

	public void save(User user){
		this.getHibernateTemplate().save(user);
	}
}
