package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring.xml");
		
		MiTv tv1 = ctx.getBean("mitv", MiTv.class);	// 주소값이 담김
		System.out.println("tv1 : " + tv1);
	}

}

// ApplicationContext -> interface
// ClassPathXmlApplicationContext -> 해당 interface를 구현한 클래스. 문자열을 값으로 받음
// classpath는 디폴트가 resources로 되어 있음

// 원래는 (Mitv)ctx.getBean("mitv") 이렇게 형변환 해주어야 함.
// 아니면 오브젝트로 리턴을 해주기 때문.
// 근데 ("mitv", MiTv.clas) 이런 식으로 오브젝트가 아닌 클래스 타입임을 알려주어도 됨.

// 컨텍스트, 스프링, 컨테이너 등등 다 사실 비슷비슷한 말임. 그냥 다 스프링이라고 봐도 됨.