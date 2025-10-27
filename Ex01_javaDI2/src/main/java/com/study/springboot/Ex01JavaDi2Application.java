package com.study.springboot;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.multi.Config;
import com.study.springboot.multi.Person;
import com.study.springboot.multi.Printer;

// @SpringBootApplication
public class Ex01JavaDi2Application {

	public static void main(String[] args) {
		// SpringApplication.run(Ex01JavaDi2Application.class, args);
		System.out.println("Hello World");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Person person1 = (Person)context.getBean("person1");
		person1.print();
		
		Person person2 = (Person)context.getBean("hello", Person.class);
		person2.print();
		
		Printer printer = context.getBean("printerA", Printer.class);
		person1.setPrinter(printer);
		person1.print();
	}
}
