package demo2.nienluan.dao;

import demo2.nienluan.model.Config;

public interface ConfigDAO {
	public Config getConFigById(Integer id);
	public void edit(Config ptk);
	public Config getById(Integer id);
	public void save(Config ptk);
	boolean checkCreate(Integer id);
}
