package demo2.nienluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo2.nienluan.model.Page_Token;
import demo2.nienluan.service.Page_TokenService;

@Controller
public class configPage_TokenController {
	@Autowired
	private Page_TokenService pts;
	
	@RequestMapping(value = "/postconfig", method = RequestMethod.GET)
	public String CreatePt(ModelMap md) {
		Page_Token pageToken= pts.getAll();
		md.addAttribute("pageToken", pageToken);
		return "postconfig";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "id") Integer id, ModelMap md) {
		Page_Token getPageTokenById = pts.getById(id);
		md.addAttribute("ptk", getPageTokenById);
		return "edit";
	}
	
	@RequestMapping(value = "/saveedit", method = RequestMethod.POST ,produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String savepfb(@ModelAttribute("ptk") Page_Token ptk) {
		pts.edit(ptk);
		return "redirect:/postconfig";
	}
	
}
