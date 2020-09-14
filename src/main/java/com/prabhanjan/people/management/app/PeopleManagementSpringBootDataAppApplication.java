package com.prabhanjan.people.management.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prabhanjan.people.management.app.entities.PersonBean;
import com.prabhanjan.people.management.app.service.PeopleManagementService;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createPerson();
		retrieveAll();
		retrieveOne();
	}

	private Optional<PersonBean> retrieveOne() {
		Optional<PersonBean> retrieveOne = peopleManagementService.retrieveOne();
		System.out.println("retrieve One from sysout" + retrieveOne);
		return retrieveOne;
	}

	private void retrieveAll() {
		List<PersonBean> retrieveAll = peopleManagementService.retrieveAll();
		for (PersonBean personBean : retrieveAll) {
			System.out.println("Prabhanjan Sysout New: " + personBean);
		}

	}

	private void createPerson() {
		List<PersonBean> personList = Arrays.asList(
				new PersonBean("Prabhanjan", "Banda", "Prabhanjan594@gmail.com", new Date()),
				new PersonBean("raju", "ramesh", "ramesh123@gmmail.com", new Date()));
		List<PersonBean> persondb = peopleManagementService.createPerson(personList);
		System.out.println("Create Person Sysout" + persondb);
	}

}
