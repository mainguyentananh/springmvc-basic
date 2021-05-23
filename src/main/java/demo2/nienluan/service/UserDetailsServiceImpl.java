package demo2.nienluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.UserDAO;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private UserDAO uDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		demo2.nienluan.model.User u = uDao.loadUserByName(username);

		if (u == null) {
			System.out.println("User not found! " + username);
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new User(u.getUsername(), u.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, u.getAuthorities());

	}

}
