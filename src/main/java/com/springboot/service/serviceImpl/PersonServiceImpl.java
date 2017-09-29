package com.springboot.service.serviceImpl;

import com.springboot.dao.PersonRepository;
import com.springboot.entity.Person;
import com.springboot.service.PersonService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *  使用缓存
 * Created by htc on 2017/9/29.
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    /**
     * @CachePut缓存新增的或更新的数据到缓存，其中缓存名称为people，数据的key是person的id
     * @param person
     * @return
     */
    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p=personRepository.save(person);
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }

    /**
     *  @CacheEvict从缓存people中删除key为id的数据
     * @param id
     */
    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id、key为"+id+"的数据缓存");
        personRepository.delete(id);
    }

    /**
     * @Cacheable缓存key为person的id数据到换出people中
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "people",key="#people.id")
    public Person findOne(Long id) {
        Person p=personRepository.findOne(id);
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }
}
