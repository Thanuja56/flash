package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Beans.Login;
import com.Service.LoginService;



@Controller
public class LoginController {
	@Autowired
	private LoginService logService;
	
	@GetMapping(value ="/")
	public String HomePage(){
		
		return "/home";
	}
	@GetMapping(value="/login")
	public String loginPage(Model model) {
		Login log = new Login();
		model.addAttribute("login1",log);
		return "login";
	}
	@RequestMapping(value = "/loginProcess",method=RequestMethod.POST)
	public String welcomePage(@ModelAttribute("login1") Login log)
{
		Login logobj = logService.getObj(log.getEmpId());
		String pass1 = logobj.getPassword();
		String pass2 = log.getPassword();
		if(("Sunil").equals(log.getUsername())&&("Sunil@123").equals(log.getPassword()) && ("admin").equals(log.getRole())) {
			return "welcomeAdmin";
		}
		else if((pass1).equals(pass2) && (log.getUsername()).equals(logobj.getUsername()) && (logobj.getRole()).equals("admin")){
			return "welcomeAdmin";
		}else if((pass1).equals(pass2) && (log.getUsername()).equals(logobj.getUsername()) && (log.getRole()).equals("accountent")) {
			return "welcomeAccountent";
		}
		return "contact";
		
		}
	@GetMapping(value ="indexstu")
	public String stu() {
		return "indexstu";
	}
	@GetMapping(value="newadmin")
	public String adminfrm(Model model) {
		Login log = new Login();
		model.addAttribute("admin",log);
		return "newadmin";
	}
	@PostMapping("/AddAdmin")
	public String addAdmin(@ModelAttribute("admin") Login log) {
		log.setRole("admin");
		logService.saveAdmin(log);
		return "redirect:/showAdmin";	
	}
	@GetMapping("/showAdmin")
	public String showAdmin(Model model) {
		List<Login> list = logService.listadmin();
		model.addAttribute("list",list);
		return "indexadmin";
		
	}
	@RequestMapping("/editadmin/{empId}")
	public ModelAndView editAdmin(@PathVariable(name="empId") int id) {
		ModelAndView mav = new ModelAndView("editad");
		Login log = logService.getObj(id);
		mav.addObject("adminedit",log);
		return mav;
		
	}
	@GetMapping("/deleteadmin/{empId}")
	public String delete(@PathVariable(name="empId") int id) {
		logService.deleteAdmin(id);
		return "redirect:/showAdmin";
	}
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/home";
	}
	
}


