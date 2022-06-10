package com.paris.controller;

import com.paris.action.Action;
import com.paris.entity.Account;
import com.paris.entity.Person;
import com.paris.model.PersonDB;

public class PersonController {
    public void save(String nationalCode, String firstName, String lastName, int age) {
        try {
            Person person = null;
            if (nationalCode.length() != 0) {
                person = new Person().setFirstName(firstName).setLastName(lastName).setNationalCode(nationalCode).setAge(age);
            }
            Action action = new Action();
            action.save(person);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void delete(long id){
        try {
            Person person = null;
            if (id == person.getId()){
                Action action = new Action();
                action.remove(id);
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
