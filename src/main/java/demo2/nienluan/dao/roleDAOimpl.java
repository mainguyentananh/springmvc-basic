package demo2.nienluan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.Role;
@Repository
public class roleDAOimpl implements roleDAO{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Role findbyRoleName(String name) {
		Session session = sessionfactory.getCurrentSession();
		Role fr = session.createQuery("from Role r where r.rolename = :name",Role.class).setParameter("name", name).getResultList().get(0);
		return fr;
	}

}
