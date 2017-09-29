package com.springboot.service;

import com.springboot.entity.Person;

/**
 * Created by htc on 2017/9/29.
 */
public interface PersonService {
    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Long id);
}
