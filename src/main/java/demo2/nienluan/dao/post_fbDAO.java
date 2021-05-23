package demo2.nienluan.dao;

import java.util.List;

import demo2.nienluan.model.Post_FB;

public interface post_fbDAO {
	public void save(Post_FB pfb);
	public void edit(Post_FB pfb);
	public void delete(Integer pfb);
	public List<Post_FB> getAll();
	public Post_FB getpfb(Integer pfb);
	public List<Post_FB> listPostFindById(Integer id);
	public List<Post_FB> getListPosted();
	public List<Post_FB> getListNotPosted();
}
