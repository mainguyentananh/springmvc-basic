package demo2.nienluan.service;

import demo2.nienluan.model.Config;

public interface ConfigService {
	public Config getConFigById(Integer id);
	public void edit(Config ptk);
	public Config getById(Integer id);
	public void save(Config ptk);
	boolean checkCreate(Integer id);

}
