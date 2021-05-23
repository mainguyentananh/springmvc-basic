package demo2.nienluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.roleDAO;
import demo2.nienluan.model.Role;

@Service
@Transactional
public class roleServiceImpl implements roleService{
	@Autowired
	private roleDAO repo;
	
	@Override
	public Role findbyRoleName(String name) {
		return repo.findbyRoleName(name);
	}

}
