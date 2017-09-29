package com.springboot.controller;

import com.springboot.common.constant.StatusConstant;
import com.springboot.common.entity.Resp;
import com.springboot.dao.PersonRepository;
import com.springboot.entity.Person;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by htc on 2017/9/28.
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public Resp save() {
        Resp resp = new Resp();
        Person p=new Person();
        p.setId((long) 23);
        p.setAge(21);
        p.setName("黄妩萍");
        p.setAddress("上海徐汇");
        Person person=personRepository.save(p);
        resp.setStatus(StatusConstant.HTTP_SUCCESS);
        resp.setData(p);
        return resp;
    }

    @RequestMapping(value = "findByAddress", method = RequestMethod.GET)
    public Resp findByAddress() {
        Resp resp = new Resp();
        List<Person> people = personRepository.findByAddress("上海");
        resp.setData(people);
        return resp;
    }

    @RequestMapping(value = "findByNameAndAddress", method = RequestMethod.GET)
    public Resp findByNameAndAddress() {
        Resp resp = new Resp();
        Person people = personRepository.findByNameAndAddress("胡廷聪", "上海");
        resp.setData(people);
        return resp;
    }


    @RequestMapping(value = "withNameAndAddressQuery", method = RequestMethod.GET)
    public Resp withNameAndAddressQuery() {
        Resp resp = new Resp();
        Person people = personRepository.withNameAndAddressQuery("胡廷聪", "上海");
        resp.setData(people);
        return resp;
    }


    @RequestMapping(value = "withNameAndAddressNamedQuery", method = RequestMethod.GET)
    public Resp withNameAndAddressNamedQuery() {
        Resp resp = new Resp();
        List<Person> people = personRepository.withNameAndAddressNamedQuery("胡廷聪", "上海");
        resp.setData(people);
        return resp;
    }

    /**
     * 排序测试
     * @return
     */
    @RequestMapping(value = "sort",method = RequestMethod.GET)
    public Resp sort(){
        List<Person> people=personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return new Resp(StatusConstant.HTTP_SUCCESS,people);
    }

    /**
     * 分页测试
     * @return
     */
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public Resp page(){
        Page<Person> personPage=personRepository.findAll(new PageRequest(1,2));
        return new Resp(StatusConstant.HTTP_SUCCESS,personPage);
    }

    /**
     * 使用缓存--新增
     * @param person
     * @return
     */
    @RequestMapping(value = "cachePut",method = RequestMethod.GET)
    public Person put(Person person){
        return personService.save(person);
    }

    /**
     * 在缓存中查找数据
     * @param id
     * @return
     */
    @RequestMapping(value = "cacheAble",method = RequestMethod.GET)
    public Person cacheable(Long id){
        Person person= personService.findOne(id);
//        Person person= personRepository.findOne((long) 7);
        return person;
    }

    @RequestMapping(value = "cacheEvict",method = RequestMethod.GET)
    public String evit(Long id){
        personService.remove(id);
        return "ok";
    }
}
