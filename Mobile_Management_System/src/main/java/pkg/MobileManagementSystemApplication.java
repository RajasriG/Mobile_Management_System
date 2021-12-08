package pkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class MobileManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileManagementSystemApplication.class, args);      
		System.out.println("hiiiiiii");	
	}
}