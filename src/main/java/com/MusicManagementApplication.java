package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class MusicManagementApplication {
	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		SpringApplication.run(MusicManagementApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/user").allowedOrigins("http://192.168.107.75:5500");
				registry.addMapping("/song").allowedOrigins("http://192.168.107.75:5500");
				registry.addMapping("/category").allowedOrigins("http://192.168.107.75:5500");
				registry.addMapping("/feedback").allowedOrigins("http://192.168.107.75:5500");
			}
		};
	}
}
