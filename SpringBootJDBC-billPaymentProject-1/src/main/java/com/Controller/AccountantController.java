package com.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Beans.Accountant;
import com.Beans.Login;
import com.Service.AccountantService;
import com.Service.LoginService;

@Controller
public class AccountantController {
	@Autowired
	private AccountantService service; 
	
	@Autowired
	private LoginService logServ;
	
	@RequestMapping("/indexacc")
	public String viewHomePage(Model model) {
		List<Accountant> listaccountants = service.listAll();
		model.addAttribute("listaccountants", listaccountants);
		
		return "indexacc";
	}
	
	@RequestMapping("/newacc")
	public String showNewAccountantPage(Model model) {
		Accountant accountant = new Accountant();
		model.addAttribute("accountant", accountant);
		
		return "newacc";
	}
	
	@RequestMapping(value = "/saveacc", method = RequestMethod.POST)
	public String saveAccountant(@ModelAttribute("accountant") Accountant accountant) {
		service.save(accountant);
		Login log = new Login();
		log.setUsername(accountant.getUsername());
		log.setPassword(accountant.getPassword());
		log.setRole("accountent");
		logServ.saveAdmin(log);
		
		return "redirect:/indexacc";
		
		
	}
	
	@RequestMapping("/editacc/{id}")
	public ModelAndView showEditAccountantPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editacc");
		Accountant accountant = service.get(id);
		mav.addObject("accountant", accountant);
		
		return mav;
	}
	
	@RequestMapping("/deleteacc/{id}")
	public String deleteAccountant(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/indexacc";		
	}
}



