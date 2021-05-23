package demo2.nienluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.user_roleDAO;
import demo2.nienluan.model.User_Role;
@Service
@Transactional
public class user_roleServiceImpl implements user_roleService{
	@Autowired
	private user_roleDAO repo;
	
	@Override
	public void save(User_Role ur) {
		repo.save(ur);
		
	}

}
