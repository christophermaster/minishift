package com.safre.coppel.mss_afiglobal;

import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import com.safre.coppel.jwtAuthorizationFilte.WebSecurityConfig;
import com.safre.coppel.mss_afiglobal.Utilities.Utilities;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Import(WebSecurityConfig.class)
public class MssAfiglobalApplication {

	public static void main(String[] args)
			throws UnsatisfiedLinkError, NullPointerException, SecurityException, IOException {
		SpringApplication application = new SpringApplication(MssAfiglobalApplication.class);
		Properties pro = new Properties();
		pro = Utilities.getMyProperties("mss_afiglobal");
		application.setDefaultProperties(pro);
		pro.putAll(System.getProperties());
		System.setProperties(pro);
		application.run(args);
	}
	
}
