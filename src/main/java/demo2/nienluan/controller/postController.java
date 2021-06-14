package demo2.nienluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo2.nienluan.model.Config;
import demo2.nienluan.model.Post;
import demo2.nienluan.service.ConfigService;
import demo2.nienluan.service.UserService;
import demo2.nienluan.service.PostService;

@Controller
public class postController {
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private ConfigService cs;
	
	
	
	@RequestMapping(value = "/createpost", method = RequestMethod.GET)
	public String CreateStd(ModelMap md) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Integer iduser = us.findIdUser(name);
		Post pfb = new Post(); 
		
		//ktra xem co config ch
		boolean check = cs.checkCreate(iduser);
		if(check == true) {
			Config newptk = new Config();
			md.addAttribute("ptk", newptk);
			md.addAttribute("Post_FB", pfb);
			return "createpost";
		}
		
		
		Config ptk = cs.getConFigById(iduser);	
		md.addAttribute("Post_FB", pfb);
		md.addAttribute("ptk", ptk);
		
		return "createpost";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST , produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String savepfb(@ModelAttribute("Post_FB") Post pfb,ModelMap md ) {
		ps.save(pfb);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Integer iduser = us.findIdUser(name);
		
		Post newpfb = new Post(); 
		Config ptk = cs.getConFigById(iduser);
		md.addAttribute("Post_FB", newpfb);
		md.addAttribute("ptk", ptk);
		
		md.addAttribute("message", "<div class=\"btn btn-success btn-sm rounded-pill\">Post Success <i class=\"fas fa-check-circle\"></i></div>");
		return "createpost";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletefbp(@PathVariable(value = "id") Integer id) {
		ps.delete(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String checkpost(@PathVariable(value = "id") Integer id) {
		Post npfb =  ps.getpfb(id);
		npfb.setCheck_post(true);
		ps.save(npfb);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
}
