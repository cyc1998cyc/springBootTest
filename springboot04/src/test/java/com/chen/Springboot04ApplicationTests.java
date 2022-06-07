package com.chen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04ApplicationTests {
	@Value("${user.passpord}")
	private int password;

	@Test
	void contextLoads() {
		System.out.println(password);
		System.out.println("陈宇超");
	}

	@Test
	void testFastJson(){
		System.out.println("test");

	}

}
