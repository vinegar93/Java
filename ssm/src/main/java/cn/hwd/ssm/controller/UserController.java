package cn.hwd.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hwd.ssm.bean.User;
import cn.hwd.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.action")  
    public ModelAndView index() throws Exception {  
		User user = userService.findUserById(1);
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("message", user);
        modelAndView.setViewName("index");  
        return modelAndView;  
    }  
	
}
