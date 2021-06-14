package demo2.nienluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo2.nienluan.model.Post;
import demo2.nienluan.model.Role;
import demo2.nienluan.model.User;
import demo2.nienluan.model.User_Role;
import demo2.nienluan.service.UserService;
import demo2.nienluan.service.PostService;
import demo2.nienluan.service.roleService;
import demo2.nienluan.service.user_roleService;

@Controller
public class loginController {

	@Autowired
	private PostService pfbs;

	@Autowired
	private UserService us;
	
	@Autowired
	private roleService rs;
	
	@Autowired
	private user_roleService urs;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model) {
		if (error != null) {
			model.addAttribute("message", "<div class=\"btn btn-danger btn-sm rounded-pill\">your password is wrong!</div>");
		}
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String user() {
	
		return "home";
	}

	@RequestMapping(value = "/postlist", method = RequestMethod.GET)
	public String userpost(ModelMap md) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Integer iduser = us.findIdUser(name);
		List<Post> listpost = pfbs.listPostFindById(iduser);
		md.addAttribute("listpost", listpost);
		return "postlist";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap md) {
		List<Post> listpost = pfbs.getAll();
		md.addAttribute("listpost", listpost);
		return "admin";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String erro403() {
		return "403";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping(value = "/admin/createaccount", method = RequestMethod.GET)
	public String createaccount(ModelMap md) {
		User nu = new User();
		md.addAttribute("nu", nu);
		return "createaccount";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String adminsave(@ModelAttribute("nu") User nu,ModelMap md) {
		
		//User
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nu.setPassword(encoder.encode(nu.getPassword()));
		
		String getName = nu.getUsername();
		
		us.save(nu);
		//end
		
		//User_Role
		User getNewUser = us.loadUserByName(getName);
		Role getRoleUser = rs.findbyRoleName("ROLE_USER");
		
		User_Role NewUser = new User_Role();
		NewUser.setUser(getNewUser);
		NewUser.setRole(getRoleUser);
		
		urs.save(NewUser);
		//end
		
		//reset form
		nu.setUsername(null);
		nu.setPassword(null);
		md.addAttribute("message", "<div class=\"btn btn-success btn-sm rounded-pill\">Success <i class=\"fas fa-check-circle\"></i></div>");
		return "createaccount";
	}
	
	@RequestMapping(value = "/admin/listposted", method = RequestMethod.GET)
	public String getListPosted(ModelMap md) {
		List<Post> listpost = pfbs.getListPosted();
		md.addAttribute("listpost", listpost);
		return "admin";
	}
	
	@RequestMapping(value = "/admin/listnotposted", method = RequestMethod.GET)
	public String getListNotPosted(ModelMap md) {
		List<Post> listpost = pfbs.getListNotPosted();
		md.addAttribute("listpost", listpost);
		return "admin";
	}
	
}
