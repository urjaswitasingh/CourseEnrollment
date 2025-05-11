package com.librarymanagement.courseenrollments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class CourseenrollmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseenrollmentsApplication.class, args);
	}

}
