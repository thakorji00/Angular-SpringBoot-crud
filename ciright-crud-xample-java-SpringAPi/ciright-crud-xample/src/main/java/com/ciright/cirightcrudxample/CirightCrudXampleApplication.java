package com.ciright.cirightcrudxample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "com.ciright.cirightcrudxample" }
,  exclude = { JpaRepositoriesAutoConfiguration.class}
	)
public class CirightCrudXampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CirightCrudXampleApplication.class, args);
	}

}
