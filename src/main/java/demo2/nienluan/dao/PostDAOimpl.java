package demo2.nienluan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo2.nienluan.model.Post;

@Repository
public class PostDAOimpl implements PostDAO{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void save(Post pfb) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(pfb);
	}

	@Override
	public void edit(Post pfb) {
		Session session = sessionfactory.getCurrentSession();
		session.update(pfb);
	}

	@Override
	public void delete(Integer pfb) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getpfb(pfb));
		
	}

	@Override
	public List<Post> getAll() {
		Session session = sessionfactory.getCurrentSession();
		List<Post> pfb = session.createQuery("from Post",Post.class).list();
		return pfb;
	}

	@Override
	public Post getpfb(Integer pfb) {
		Session session = sessionfactory.getCurrentSession();
		Post postfb = session.get(Post.class, pfb);
		return postfb;
	}

	@Override
	public List<Post> listPostFindById(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		List<Post> pfb = session.createQuery("from Post p where p.id_user = :id", Post.class).setParameter("id", id).list();
		return pfb;
	}

	@Override
	public List<Post> getListPosted() {
		Session session = sessionfactory.getCurrentSession();
		List<Post> getlistposted = session.createQuery("from Post p where p.check_post ="+true,Post.class).list();
		return getlistposted;
	}

	@Override
	public List<Post> getListNotPosted() {
		Session session = sessionfactory.getCurrentSession();
		List<Post> getlistnotposted = session.createQuery("from Post p where p.check_post ="+false,Post.class).list();
		return getlistnotposted;
	}

	
	
}
