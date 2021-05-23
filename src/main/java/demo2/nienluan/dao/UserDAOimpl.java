package demo2.nienluan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.User;

@Repository
public class UserDAOimpl implements UserDAO {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public User loadUserByName(String username) {
		Session session = sessionfactory.getCurrentSession();
		List<User> user = session.createQuery(" from User u where u.username = :username", User.class)
				.setParameter("username", username).list();

		return user.get(0);

	}

	@Override
	public Integer findIdUser(String username) {
		Session session = sessionfactory.getCurrentSession();
		User user = session.createQuery(" from User u where u.username = :username", User.class)
				.setParameter("username", username).getResultList().get(0);
		Integer id = user.getId();
		return id;
	}

	@Override
	public void save(User u) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(u);
	}

}
