package com.chenshun.test.space;

import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;

/**
 * User: chenshun131 <p />
 * Time: 18/8/26 17:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface PersonRepository extends CrudRepository<Person, Name> {

}
