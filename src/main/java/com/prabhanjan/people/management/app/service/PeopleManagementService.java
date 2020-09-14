package com.prabhanjan.people.management.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabhanjan.people.management.app.dao.PeopleManagementDao;
import com.prabhanjan.people.management.app.entities.PersonBean;

@Service
public class PeopleManagementService {
	@Autowired
	private PeopleManagementDao peopleManagementDao;

	public List<PersonBean> createPerson(List<PersonBean> personList) {

		return (List<PersonBean>) peopleManagementDao.saveAll(personList);
	}

	public List<PersonBean> retrieveAll() {
		return (List<PersonBean>) peopleManagementDao.findAll();

	}

	public Optional<PersonBean> retrieveOne() {
		Optional<PersonBean> findById = null;
		long count = peopleManagementDao.count();
		System.out.println("Count from Table" + count);
		if (peopleManagementDao.existsById(1)) {
			Optional<PersonBean> findById1 = peopleManagementDao.findById(1);
			findById = findById1;
		}
		return findById;
	}

}
