package demo2.nienluan.dao;

import demo2.nienluan.model.User;

public interface UserDAO {
	public User loadUserByName(String username);
	public Integer findIdUser(String username);
	public void save(User u);
}
