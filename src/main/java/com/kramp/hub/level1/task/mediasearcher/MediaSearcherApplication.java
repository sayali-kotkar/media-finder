package com.kramp.hub.level1.task.mediasearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableHystrix
public class MediaSearcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaSearcherApplication.class, args);
	}

}
