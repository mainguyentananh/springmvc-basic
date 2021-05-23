package demo2.nienluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.UserDAO;
import demo2.nienluan.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO repo;
	
	@Override
	public User loadUserByName(String username) {
		return repo.loadUserByName(username);
	}

	@Override
	public Integer findIdUser(String username) {
		return repo.findIdUser(username);
	}

	@Override
	public void save(User u) {
		repo.save(u);
	}

}
