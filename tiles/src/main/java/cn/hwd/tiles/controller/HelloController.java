package cn.hwd.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.action")
	public String hello() throws Exception {
		return "hello"; // �����helloΪlayout.xml�����õ���ͼ���ƣ����ݷ���ֵ��ȥƥ���Ӧ��jspҳ��
	}
	
}
