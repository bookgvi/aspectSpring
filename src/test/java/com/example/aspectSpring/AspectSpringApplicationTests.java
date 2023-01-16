package com.example.aspectSpring;

import com.example.aspectSpring.domain.Greetings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest
class AspectSpringApplicationTests implements ApplicationContextAware {
	private ApplicationContext ctx;

	@Test
	void contextLoads() {
		Greetings greetingsBean = (Greetings) ctx.getBean("greetingsImpl");
		Assertions.assertNotNull(greetingsBean);
		Assertions.assertDoesNotThrow(() -> greetingsBean.getClass().getDeclaredField("id"));
		Assertions.assertDoesNotThrow(() -> greetingsBean.getClass().getDeclaredField("msg"));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
}
