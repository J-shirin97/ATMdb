package com.paris.action;

import com.paris.entity.Person;
import com.paris.model.PersonDB;

public class Action {
    public void save(Person person){
        PersonDB personDB = new PersonDB();
        personDB.insert(person);
    }
    public void remove(long id){
        PersonDB personDB = new PersonDB();
        personDB.delete(id);
    }



}

