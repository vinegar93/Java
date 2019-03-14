package cn.hwd.paging.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hwd.paging.bean.PageBean;
import cn.hwd.paging.bean.User;
import cn.hwd.paging.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.action")  
    public String index(
    		@RequestParam(value="pc", required=true, defaultValue="1") Integer pc, 
    		Model model) throws Exception {
		PageBean<User> pb = new PageBean<User>();
		pb.setPc(pc);
		int ps = 10;
		pb.setPs(ps);
		int tr = userService.count();
		pb.setTr(tr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("m", (pc - 1) * ps);
		map.put("n", ps);
		List<User> users = userService.findAll(map);
		pb.setList(users);
		model.addAttribute("pb", pb);
        return "index";
    }
	
}
