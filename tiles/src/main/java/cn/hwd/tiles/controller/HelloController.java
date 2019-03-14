package cn.hwd.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.action")
	public String hello() throws Exception {
		return "hello"; // 这里的hello为layout.xml中配置的视图名称，根据返回值，去匹配对应的jsp页面
	}
	
}
