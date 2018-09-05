package com.chenshun.test;

import com.chenshun.test.space.Person;
import com.chenshun.test.space.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: chenshun131 <p />
 * Time: 18/8/26 17:57  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2ApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findAll() throws Exception {
        System.out.println("==========================START==========================");
        personRepository.findAll().forEach(System.out::println);
        System.out.println("==========================END==========================");
    }

    @Test
    public void save() throws Exception {
        Person person = new Person();
        person.setUid("uid:1");
        person.setSuerName("AAA");
        person.setCommonName("aaa");
        person.setUserPassword("123456");
        personRepository.save(person);

        personRepository.findAll().forEach(System.out::println);
    }

}

