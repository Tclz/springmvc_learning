package com.service.impl;

import com.dao.IPersonDao;
import com.domain.Person;
import com.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public List<Person> findAll() {
        System.out.println("业务层，查询所有人员");
        return personDao.findAll();
    }

    @Override
    public void savePerson(Person person) {
        System.out.println("业务层，保存人员信息");
        personDao.savePerson(person);

    }
}
