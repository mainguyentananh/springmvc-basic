package demo2.nienluan.dao;

import java.util.List;

import demo2.nienluan.model.Post;

public interface PostDAO {
	public void save(Post pfb);
	public void edit(Post pfb);
	public void delete(Integer pfb);
	public List<Post> getAll();
	public Post getpfb(Integer pfb);
	public List<Post> listPostFindById(Integer id);
	public List<Post> getListPosted();
	public List<Post> getListNotPosted();
}
