package demo2.nienluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.ConfigDAO;
import demo2.nienluan.model.Config;

@Service
@Transactional
public class ConfigServiceImpl implements ConfigService{
	@Autowired
	private ConfigDAO ptd;
	
	
	@Override
	public void save(Config ptk) {
		 ptd.save(ptk);
	}
	
	@Override
	public Config getConFigById(Integer id) {
		return ptd.getConFigById(id);
	}

	@Override
	public void edit(Config ptk) {
		ptd.edit(ptk);
		
	}

	@Override
	public Config getById(Integer id) {
		return ptd.getById(id);
	}

	@Override
	public boolean checkCreate(Integer id) {
		return ptd.checkCreate(id);
	}

	

}
