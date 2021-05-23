package demo2.nienluan.service;

import demo2.nienluan.model.User;

public interface UserService {
	public User loadUserByName(String username);
	public Integer findIdUser(String username);
	public void save(User u);
}
