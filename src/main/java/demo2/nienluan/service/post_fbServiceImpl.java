package demo2.nienluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.post_fbDAO;
import demo2.nienluan.model.Post_FB;

@Service
@Transactional
public class post_fbServiceImpl implements post_fbService {

	@Autowired
	private post_fbDAO fbd;

	@Override
	public void save(Post_FB pfb) {
		fbd.save(pfb);

	}

	@Override
	public void edit(Post_FB pfb) {
		fbd.edit(pfb);

	}

	@Override
	public void delete(Integer pfb) {
		fbd.delete(pfb);

	}

	@Override
	public List<Post_FB> getAll() {
		return fbd.getAll();
	}

	@Override
	public Post_FB getpfb(Integer pfb) {
		return fbd.getpfb(pfb);
	}

	@Override
	public List<Post_FB> listPostFindById(Integer id) {
		return fbd.listPostFindById(id);
	}

	@Override
	public List<Post_FB> getListPosted() {
		return fbd.getListPosted();
	}

	@Override
	public List<Post_FB> getListNotPosted() {
		return fbd.getListNotPosted();
	}

}
