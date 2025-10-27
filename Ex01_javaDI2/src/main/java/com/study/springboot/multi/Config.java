package com.study.springboot.multi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 *  @COnfiguration : 스프링 부트가 시작하면서 이 어노테이션이 붙은 설정파일로 사용
 * 
 */
@Configuration
public class Config {
	@Bean 
	public Person person1() {
		Person person1 = new Person();
		person1.setName("더조은");
		person1.setNickname("tjouen");
		person1.setPrinter(new PrinterA());
		
		return person1;
	}
	
	@Bean(name="hello")
	public Person person2() {
		return new Person("홍길동", "아버리자루부부루", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
}
