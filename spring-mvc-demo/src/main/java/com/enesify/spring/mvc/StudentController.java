package com.enesify.spring.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private LinkedHashMap<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a new student object
		Student student = new Student();

		// add student object to the model
		theModel.addAttribute("student", student);
		
		theModel.addAttribute("countryOptions", countryOptions);

		return "student-form";

	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {

		// log the input data
		System.out.println("student: " + student.getFirstName() + " " + student.getLastName());
		return "student-confirmation";

	}

}
