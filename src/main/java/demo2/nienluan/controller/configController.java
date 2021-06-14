package demo2.nienluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo2.nienluan.model.Config;
import demo2.nienluan.service.ConfigService;
import demo2.nienluan.service.UserService;


@Controller
public class configController {
	@Autowired
	private ConfigService pts;
	
	@Autowired
	private UserService us;


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "id") Integer id, ModelMap md) {
		Config getPageTokenById = pts.getById(id);
		md.addAttribute("ptk", getPageTokenById);
		return "edit";
	}
	
	@RequestMapping(value = "/saveedit", method = RequestMethod.POST ,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String savepfb(@ModelAttribute("ptk") Config ptk) {
		pts.edit(ptk);
		return "redirect:/postconfig";
	}
	
	@GetMapping(value = "postconfig")
	public String postconfig(ModelMap md) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Integer iduser = us.findIdUser(name);
		
		//ktra create config
		boolean check = pts.checkCreate(iduser);
		if(check == true) {
			Config newptk = new Config();
			md.addAttribute("ptk", newptk);
			md.addAttribute("id_user", iduser);
			return "createconfig";
		}
		
		//roi thi show ra
		Config ptk = pts.getConFigById(iduser);
		md.addAttribute("pageToken", ptk);
		return "postconfig";
	}
	
	
	
	@RequestMapping(value = "/saveconfig", method = RequestMethod.POST ,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String save(@ModelAttribute("ptk") Config ptk,ModelMap md) {
		pts.save(ptk);
		return "redirect:/postconfig";
	}
	
}
