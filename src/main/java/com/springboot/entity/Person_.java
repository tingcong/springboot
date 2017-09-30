package com.springboot.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 *  Criteria Api
 * Created by htc on 2017/9/30.
 */
@StaticMetamodel(Person.class)
public class Person_ {
    public static volatile SingularAttribute<Person,Long> id;
    public static volatile SingularAttribute<Person,String> name;
    public static volatile SingularAttribute<Person,Integer> age;
    public static volatile SingularAttribute<Person,String> address;
}
