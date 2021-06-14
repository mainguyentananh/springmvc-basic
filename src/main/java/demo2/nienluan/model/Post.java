package demo2.nienluan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tPost")
public class Post implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_post")
	private Integer id ;
	
	@Column(name = "id_page")
	private String id_page ;
	
	@Column(name = "name_page")
	private String name_page ;
	 
	@Column(name = "link_page")
	private String link_page ;
	 
	@Column(name = "access_token")
	private String access_token ;
	 
	@Column(name = "content")
	private String content;
	
	@Column(name = "id_user")
	private Integer id_user;
	
	@Column(name = "check_post")
	private boolean check_post;
	
	public Post() {
	
	}


	public Post(Integer id, String id_page, String name_page, String link_page, String access_token, String content,
			Integer id_user, boolean check_post) {
		this.id = id;
		this.id_page = id_page;
		this.name_page = name_page;
		this.link_page = link_page;
		this.access_token = access_token;
		this.content = content;
		this.id_user = id_user;
		this.check_post = check_post;
	}



	public boolean isCheck_post() {
		return check_post;
	}



	public void setCheck_post(boolean check_post) {
		this.check_post = check_post;
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

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}


}
