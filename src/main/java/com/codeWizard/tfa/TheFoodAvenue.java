package com.codeWizard.tfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*      ***************************************************************    *\
 * 		Author: Swapnava Halder
 * 		Details: Backend for The Food Avenue
 * 		Project Span: 25th July 2021 - 5th August 2021 (Backend)
 */


@SpringBootApplication
@ComponentScan({"com.codeWizard.tfa.service","com.codeWizard.tfa.repository","com.codeWizard.tfa.controller"})
@EntityScan("com.codeWizard.tfa.entities")
@EnableJpaRepositories("com.codeWizard.tfa.repository")
@EnableSwagger2
public class TheFoodAvenue {

	public static void main(String[] args) {
		SpringApplication.run(TheFoodAvenue.class, args);
	}
}
