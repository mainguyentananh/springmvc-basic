package demo2.nienluan.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "tUser")
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "pass")
	private String password;



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	
	private List<User_Role> userrole;

	public User() {
	}

	public User(Integer id, String username, String password, List<User_Role> userrole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	
		this.userrole = userrole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public List<User_Role> getUserrole() {
		return userrole;
	}

	public void setUserrole(List<User_Role> userrole) {
		this.userrole = userrole;
	}

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (User_Role usersRoles : this.userrole) {
			authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getRolename()));
		}
		return authorities;
	}

}
