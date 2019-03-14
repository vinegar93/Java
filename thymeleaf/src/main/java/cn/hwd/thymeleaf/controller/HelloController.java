package cn.hwd.thymeleaf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
		request.setAttribute("message", "Hello world.");
		return "index";
    }
	
}
