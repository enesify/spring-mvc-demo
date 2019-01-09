package com.enesify.spring.mvc;

import java.lang.invoke.MethodHandles;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	// add an initbinder.. to convert trim strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmerEditor);
		
	}

	@RequestMapping("/showForm")
	public String showModel(Model model) {

		model.addAttribute("customer", new Customer());

		return "customer-form";

	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

		LOGGER.info("Last name: |" + customer.getLastName() + "|" );
		
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}

		else {
			return "customer-confirmation";
		}

	}

}
