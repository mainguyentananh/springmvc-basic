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

import demo2.nienluan.model.Page_Token;
import demo2.nienluan.model.Post_FB;
import demo2.nienluan.service.Page_TokenService;
import demo2.nienluan.service.UserService;
import demo2.nienluan.service.post_fbService;

@Controller
public class postController {
	
	@Autowired
	private post_fbService pfbs;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private Page_TokenService ptks;
	
	
	
	@RequestMapping(value = "/createpost", method = RequestMethod.GET)
	public String CreateStd(ModelMap md) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Integer iduser = us.findIdUser(name);
		Post_FB pfb = new Post_FB(); 
		Page_Token ptk = ptks.getAll();	
		md.addAttribute("Post_FB", pfb);
		md.addAttribute("ptk", ptk);
		md.addAttribute("iduser", iduser);
		
		return "createpost";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST , produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String savepfb(@ModelAttribute("Post_FB") Post_FB pfb,ModelMap md ) {
		pfbs.save(pfb);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Integer iduser = us.findIdUser(name);
		Post_FB newpfb = new Post_FB(); 
		Page_Token ptk = ptks.getAll();	
		md.addAttribute("Post_FB", newpfb);
		md.addAttribute("ptk", ptk);
		md.addAttribute("iduser", iduser);
		md.addAttribute("message", "<div class=\"btn btn-success btn-sm rounded-pill\">Post Success <i class=\"fas fa-check-circle\"></i></div>");
		return "createpost";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletefbp(@PathVariable(value = "id") Integer id) {
		pfbs.delete(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String checkpost(@PathVariable(value = "id") Integer id) {
		Post_FB npfb =  pfbs.getpfb(id);
		npfb.setCheck_post(true);
		pfbs.save(npfb);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
}
