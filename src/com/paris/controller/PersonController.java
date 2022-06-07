package com.paris.controller;

import com.paris.entity.Person;
import com.paris.model.PersonDB;

public class PersonController {
    public void save(String nationalCode, String firstName, String lastName, int age) {
        try {
            Person person = null;
            if (nationalCode.length() != 0) {
                person = new Person().setFirstName(firstName).setLastName(lastName).setNationalCode(nationalCode).setAge(age);
            }
            PersonDB personDB = new PersonDB();
            personDB.insert(person);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
