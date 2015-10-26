package com.springcookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class.
 * 
 * @author Inka
 */

//@Controller annotation on class name declares this class as spring bean
@Controller
//@RequestMapping annotation declares that this class is default handler for all requests of type �/�
@RequestMapping("/")
public class HelloController {
	//First method does not have any mapping declared so, it will inherit 
	//the mapping from mapping declared on class level, acting as default handler for GET requests
	@RequestMapping(method = RequestMethod.GET)
	// ModelMap is a Map implementation, which here acting as replacement of 
	//[request.getAttribute()/request.setAttribute()]setting values as request attribute. 
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		//This value will be suffixed and prefixed with suffix and prefix defined in view resolver to form the real view file name
		return "welcome";
	}
	
	//serve the request of form /helloagain
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}
}
