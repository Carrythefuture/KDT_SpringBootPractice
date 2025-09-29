package com.kedu.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CROSConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 서버의 어떤 url 로 요청을 하든
		.allowedOrigins("*")	   // 모든 출처
		.allowedMethods("*")	   // 모든 요청 방식
		.allowedHeaders("*");	   // 모든 요청 헤더에 대해 전부 허가 하겠음.
//		이 서버에 들어오는 모든 리퀘스트 매핑 요청들에 대하여 허락해준다.
	}
}
