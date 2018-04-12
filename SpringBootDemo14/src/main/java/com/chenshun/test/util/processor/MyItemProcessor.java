package com.chenshun.test.util.processor;

import com.chenshun.test.bean.Person;
import org.springframework.batch.core.ItemProcessListener;

/**
 * User: mew <p />
 * Time: 18/4/11 15:44  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class MyItemProcessor implements ItemProcessListener<Person, Person> {

    @Override
    public void beforeProcess(Person person) {
    }

    @Override
    public void afterProcess(Person person, Person person2) {
    }

    @Override
    public void onProcessError(Person person, Exception e) {
    }

}
