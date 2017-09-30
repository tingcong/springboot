package com.springboot.dao;

import com.springboot.entity.Person;
import com.springboot.entity.Person_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by htc on 2017/9/30.
 */
@Repository
public class PersonDao {
    //    @Autowired
    @PersistenceContext//@Autowired和@PersistenceContext注解任取一
    EntityManager em;

    @SuppressWarnings("unused")
    public List<Person> getPersonInfo(final String name,final Integer age,final String address){

        CriteriaBuilder cb=em.getCriteriaBuilder();

        CriteriaQuery<Person> query=cb.createQuery(Person.class);
        //from
        Root<Person> root=query.from(Person.class);
        //where
        Predicate p1=null;
        if(age != 0){
            System.out.println("正在操作age...");
            Predicate p2=cb.equal(root.get(Person_.age),age);
            if(p1 != null){
                p1=cb.and(p1,p2);
            }else {
                p1=p2;
            }
        }
        if(false == name.isEmpty()){
            System.out.println("正在操作name...");
            Predicate p2=cb.equal(root.get(Person_.name),name);
            if(p1 != null){
                p1=cb.and(p1,p2);
            }else {
                p1=p2;
            }
        }
        if( null != address){
            System.out.println("正在操作address...");
            Predicate p2=cb.equal(root.get(Person_.address),address);
            if(p1 != null){
                p1=cb.and(p1,p2);
            }else {
                p1=p2;
            }
        }

        query.where(p1);

        List<Person> people=em.createQuery(query).getResultList();
        return people;
    };
}
