package com.example.aspectSpring;

import com.example.aspectSpring.advise.GreetingsDecoratorAdvice;
import com.example.aspectSpring.domain.Greetings;
import com.example.aspectSpring.domain.GreetingsImpl;
import com.example.aspectSpring.pointcut.GreetingsStaticPointcut;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectSpringApplication.class, args);

		Greetings greetings = GreetingsImpl.builder().msg("QQQ").build();

		Advice greetingsDecoratorAdvice = new GreetingsDecoratorAdvice();
		Pointcut pc = new GreetingsStaticPointcut();
		Advisor advisor = new DefaultPointcutAdvisor(pc, greetingsDecoratorAdvice);

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(greetings);
		Greetings greetingsProxy = (Greetings) pf.getProxy();

		greetingsProxy.sayHello();
//		System.out.println(((GreetingsImpl) greetingsProxy).getMsg());
		greetings.sayHello();
	}

}
