package org.sid;

import org.sid.entities.Company;
import org.sid.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompanyRepository companyRepository){
		return args -> {
			Stream.of("A","B","C").forEach(company->{
				companyRepository.save(new Company(null,company,100+Math.random()*900));
			});
			companyRepository.findAll().forEach(System.out::println);
		};
	}
}
