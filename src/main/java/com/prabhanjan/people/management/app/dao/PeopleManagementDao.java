package com.prabhanjan.people.management.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prabhanjan.people.management.app.entities.PersonBean;

public interface PeopleManagementDao extends CrudRepository<PersonBean, Integer> {

}
