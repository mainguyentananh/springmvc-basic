package demo2.nienluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.PostDAO;
import demo2.nienluan.model.Post;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO fbd;

	@Override
	public void save(Post pfb) {
		fbd.save(pfb);

	}

	@Override
	public void edit(Post pfb) {
		fbd.edit(pfb);

	}

	@Override
	public void delete(Integer pfb) {
		fbd.delete(pfb);

	}

	@Override
	public List<Post> getAll() {
		return fbd.getAll();
	}

	@Override
	public Post getpfb(Integer pfb) {
		return fbd.getpfb(pfb);
	}

	@Override
	public List<Post> listPostFindById(Integer id) {
		return fbd.listPostFindById(id);
	}

	@Override
	public List<Post> getListPosted() {
		return fbd.getListPosted();
	}

	@Override
	public List<Post> getListNotPosted() {
		return fbd.getListNotPosted();
	}

}
