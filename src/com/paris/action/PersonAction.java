package com.paris.action;

import com.paris.entity.Person;
import com.paris.model.PersonDB;

import java.util.List;

public class PersonAction {
    public void save(Person person){
        PersonDB personDB = new PersonDB();
        personDB.insert(person);
    }
    public void remove(long id){
        PersonDB personDB = new PersonDB();
        personDB.delete(id);
    }

    public List<Person> show(){
        PersonDB personDB = new PersonDB();
        List<Person> personList = personDB.selectAll();
        return personList;
    }




}

