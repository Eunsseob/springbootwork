package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * @Controller : bean으로 등록한다.
 */
@Controller
public class MyController {
	@Autowired
	Person Person1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printer;
	
	@Autowired
	Person Person2;
	
	@RequestMapping("/")
	public @ResponseBody String root() {

		Person1.setPrinter(printer);
		Person1.setName("김지원");
		Person1.setNickname("등등");
		Person1.print();
		
		if(Person1 == Person2) {
			System.out.println("동일한 객체");
		}else {
			System.out.println("다른 객체");
		}
		
		
		Person2.setName("홍길동");
		Person2.setNickname("ㅎㅎ");
		
		Person2.print();
		Person1.print();
		
		return "Annotation 사용하기";
	}
}