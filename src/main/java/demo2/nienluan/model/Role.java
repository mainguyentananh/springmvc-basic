package demo2.nienluan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tRole")
public class Role implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_role")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "rolename")
	private String rolename;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
	private List<User_Role> userrole ;

	public Role() {
	}

	public Role(Integer id, String rolename, List<User_Role> userrole) {
		this.id = id;
		this.rolename = rolename;
		this.userrole = userrole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<User_Role> getUserrole() {
		return userrole;
	}

	public void setUserrole(List<User_Role> userrole) {
		this.userrole = userrole;
	}

	
	
	
}
