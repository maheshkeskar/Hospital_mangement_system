package com.mahesh101;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class HospitalManagementSystemApplication {
	@Value("{authorName}")
	String authorName;

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
		log.info("HospitalManagementSystem...");
	}

}
