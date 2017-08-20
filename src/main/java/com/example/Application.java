package com.example;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DepartmentRepository developerRepository;

    @Autowired
    MailRepository mailRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		//Here we are loading the data to tables through H2.
		Mail cseone = new Mail("cseone",1);
		Mail csetwo = new Mail("csetwo",1);
		Mail csethree = new Mail("csethree",1);
		Mail itone = new Mail("itone",2);
		Mail ittwo = new Mail("ittwo",2);
		Mail eceone = new Mail("eceone",3);
		Mail ecetwo = new Mail("ecetwo",3);
		Mail ecethree = new Mail("ecethree",3);

		mailRepository.save(cseone);
		mailRepository.save(csetwo);
		mailRepository.save(csethree);
		mailRepository.save(itone);
		mailRepository.save(ittwo);
		mailRepository.save(eceone);
		mailRepository.save(ecetwo);
		mailRepository.save(ecethree);
		

		List<Department> developers = new LinkedList<Department>();
		developers.add(new Department(1, "cse", 
				Arrays.asList(new Mail[] { cseone, csetwo, csethree })));
		developers.add(new Department(2, "it",
				Arrays.asList(new Mail[] { itone, ittwo })));
		developers.add(new Department(3, "ece",
				Arrays.asList(new Mail[] { eceone, ecetwo, ecethree })));
		developerRepository.save(developers);
	}

}
