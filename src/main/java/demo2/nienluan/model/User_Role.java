package demo2.nienluan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class User_Role implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_user_role;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private	User user;

	@ManyToOne
    @JoinColumn(name = "role_id")
    private	Role role;

	public User_Role() {
	}

	public User_Role(Integer id_user_role, User user, Role role) {
		this.id_user_role = id_user_role;
		this.user = user;
		this.role = role;
	}

	public Integer getId_user_role() {
		return id_user_role;
	}

	public void setId_user_role(Integer id_user_role) {
		this.id_user_role = id_user_role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
    
}
