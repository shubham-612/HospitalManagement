package com.cg.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.ws.config.annotation.EnableWs;
@SpringBootApplication
@EnableConfigServer
public class SpringSecurityConfigCloudProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityConfigCloudProductApplication.class, args);
	}

}