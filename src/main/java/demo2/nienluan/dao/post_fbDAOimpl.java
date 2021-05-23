package demo2.nienluan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.Post_FB;

@Repository
public class post_fbDAOimpl implements post_fbDAO{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void save(Post_FB pfb) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(pfb);
	}

	@Override
	public void edit(Post_FB pfb) {
		Session session = sessionfactory.getCurrentSession();
		session.update(pfb);
	}

	@Override
	public void delete(Integer pfb) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getpfb(pfb));
		
	}

	@Override
	public List<Post_FB> getAll() {
		Session session = sessionfactory.getCurrentSession();
		List<Post_FB> pfb = session.createQuery("from Post_FB",Post_FB.class).list();
		return pfb;
	}

	@Override
	public Post_FB getpfb(Integer pfb) {
		Session session = sessionfactory.getCurrentSession();
		Post_FB postfb = session.get(Post_FB.class, pfb);
		return postfb;
	}

	@Override
	public List<Post_FB> listPostFindById(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		List<Post_FB> pfb = session.createQuery("from Post_FB pfb where pfb.id_user = :id", Post_FB.class).setParameter("id", id).list();
		return pfb;
	}

	@Override
	public List<Post_FB> getListPosted() {
		Session session = sessionfactory.getCurrentSession();
		List<Post_FB> getlistposted = session.createQuery("from Post_FB pfb where pfb.check_post ="+true,Post_FB.class).list();
		return getlistposted;
	}

	@Override
	public List<Post_FB> getListNotPosted() {
		Session session = sessionfactory.getCurrentSession();
		List<Post_FB> getlistnotposted = session.createQuery("from Post_FB pfb where pfb.check_post ="+false,Post_FB.class).list();
		return getlistnotposted;
	}

	
	
}
