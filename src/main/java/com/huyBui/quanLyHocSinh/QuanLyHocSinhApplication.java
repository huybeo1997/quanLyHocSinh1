package com.huyBui.quanLyHocSinh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {
        "com.yourpackagepath.mapper"},
						exclude = {
		SecurityAutoConfiguration.class })
public class QuanLyHocSinhApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyHocSinhApplication.class, args);
	}

}
