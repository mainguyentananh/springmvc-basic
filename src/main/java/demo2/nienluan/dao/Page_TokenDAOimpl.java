package demo2.nienluan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.Page_Token;

@Repository
public class Page_TokenDAOimpl implements Page_TokenDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	@SuppressWarnings("unchecked")
	public Page_Token getAll() {
		Session session = sessionfactory.getCurrentSession();
		List<Page_Token> lpt = session.createQuery("from Page_Token").list();
		return lpt.get(0);
	}

	@Override
	public void edit(Page_Token ptk) {
		Session session = sessionfactory.getCurrentSession();
		session.update(ptk);

	}

	@Override
	public Page_Token getById(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		Page_Token getPage_TokenById = session.get(Page_Token.class, id);
		return getPage_TokenById;
	}

}
