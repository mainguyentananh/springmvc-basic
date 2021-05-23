package demo2.nienluan.dao;

import demo2.nienluan.model.Page_Token;

public interface Page_TokenDAO {
	public Page_Token getAll();
	public void edit(Page_Token ptk);
	public Page_Token getById(Integer id);

}
