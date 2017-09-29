package com.springboot.dao;

import com.springboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by htc on 2017/9/28.
 *      Spring Data REST的默认规则是在实体类之后加S来形成路径，
 *      可以通过@RepositoryRestResource注解来修改
 */
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person,Long>{
    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name,String address);

//    @Query("select p from Person p where p.address=?1")
//    List<Person> findByAddress(String address);

    /** 根据query查询   */
    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);

    /** 根据实体类中@NameQuery定义的query查询*/
    List<Person> withNameAndAddressNamedQuery(String name,String address);

    /** 通过注解@RestResource将方法暴露为REST资源*/
    @RestResource(path = "nameStartsWith",rel = "nameStartWith")
    List<Person> findByNameStartsWith(@Param("name") String name);

    /**     获得符合查询条件的前10条数据 */
    List<Person> findFirst10ByName(String name);

    /** 获得符合查询条件的前30条数据 */
    List<Person> findTop30ByName(String name);

    /**
     *  更新查询
     *  @Modifying+@Query组合
     **/
    @Modifying
    @Transactional
    @Query("update Person p set p.name=?1")
    int setName(String name);
}
