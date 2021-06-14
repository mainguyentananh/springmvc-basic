package demo2.nienluan.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.Config;

@Repository
public class ConfigDAOimpl implements ConfigDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override

	public Config getConFigById(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		Config lpt = session.createQuery("from Config pt where pt.id_user ="+id,Config.class).getResultList().get(0);
		
		return lpt;
	}

	public boolean checkCreate(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		boolean lpt = session.createQuery(" from Config pt where pt.id_user ="+id).list().isEmpty();
		if(!lpt) {
			return false;
		}	
		return true;
	}
	
	@Override
	public void edit(Config ptk) {
		Session session = sessionfactory.getCurrentSession();
		session.update(ptk);

	}
	
	@Override
	public void save(Config ptk) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(ptk);

	}

	@Override
	public Config getById(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		Config getConfigById = session.get(Config.class, id);
		return getConfigById;
	}


	
}
