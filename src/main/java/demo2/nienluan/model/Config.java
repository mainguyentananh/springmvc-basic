package demo2.nienluan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tConfig")
public class Config implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_config")
	private Integer id;

	@Column(name = "id_user")
	private Integer id_user;
	
	@Column(name = "id_page")
	private String id_page;
	
	@Column(name = "name_page")
	private String name_page;
	
	@Column(name = "link_page")
	private String link_page;
	
	
	@Column(name = "access_token")
	private String token;

	
	
	public Config() {
	}

	public Config(Integer id,Integer id_user, String id_page, String name_page, String link_page, String token) {
		this.id = id;
		this.id_user = id_user;
		this.id_page = id_page;
		this.name_page = name_page;
		this.link_page = link_page;
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getId_page() {
		return id_page;
	}

	public void setId_page(String id_page) {
		this.id_page = id_page;
	}

	public String getName_page() {
		return name_page;
	}

	public void setName_page(String name_page) {
		this.name_page = name_page;
	}

	public String getLink_page() {
		return link_page;
	}

	public void setLink_page(String link_page) {
		this.link_page = link_page;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	
	

}
