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

import com.Beans.Student;
import com.Service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service; 
	
	
	@RequestMapping("/home")
	public String viewWelcomePage(Model model) {
	return "Home";
		
	}
	
	@RequestMapping("showstu")
	public String viewHomePage(Model model) {
		List<Student> listStudents = service.listAll();
		model.addAttribute("listStudents", listStudents);
		
		return "indexstu";
	}
	
	@RequestMapping("/newstu")
	public String showNewStudentPage(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "newstu";
	}
	
	@RequestMapping(value = "/savestu", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		
		return "redirect:/showstu";
	}
	
	@RequestMapping("/editstu/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editstu");
		Student student = service.get(id);
		mav.addObject("student", student);
		
		return mav;
	}
	
	@RequestMapping("/deletestu/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/showstu";		
	}
	
}


	
	

	

