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

import com.Beans.Payment;
import com.Service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService service; 
	
	@RequestMapping("/indexpay")
	public String viewHomePage(Model model) {
		List<Payment> listBilling = service.listAll();
		model.addAttribute("listBilling", listBilling);
		
		return "indexpay";
	}
	
	@RequestMapping("/newpay")
	public String showNewBillingPage(Model model) {
		Payment billing = new Payment();
		model.addAttribute("Billing", billing);
		
		return "newpay";
	}
	
	@RequestMapping(value = "/savepay", method = RequestMethod.POST)
	public String saveBilling(@ModelAttribute("billing") Payment billing) {
		service.save(billing);
		
		return "redirect:/indexpay";
	}
	
	@RequestMapping("/editpay/{id}")
	public ModelAndView showEditBillingPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editpay");
		Payment billing = service.get(id);
		mav.addObject("billing", billing);
		
		return mav;
	}
	
	@RequestMapping("/deletepay/{id}")
	public String deleteBilling(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/indexpay";		
	}
}

