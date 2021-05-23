package demo2.nienluan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.User_Role;

@Repository
public class user_roleDAOimpl implements user_roleDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void save(User_Role ur) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(ur);	
	}

}
