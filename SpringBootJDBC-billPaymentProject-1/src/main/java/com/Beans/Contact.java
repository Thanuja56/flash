package com.Beans;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


	@Controller
	public class Contact {
		@RequestMapping(value ="/contact",method = RequestMethod.GET)
		public String contactPage() {
			return "contact";
		}
	}