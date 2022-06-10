package com.paris.controller;

import com.paris.action.PersonAction;
import com.paris.entity.Person;
import com.paris.model.PersonDB;

import javax.xml.transform.Result;
import java.util.List;

public class PersonController {
    public void save(String nationalCode, String firstName, String lastName, int age) {
        try {
            Person person = null;
            if (nationalCode.length() != 0) {
                person = new Person().setFirstName(firstName).setLastName(lastName).setNationalCode(nationalCode).setAge(age);
            }
            PersonAction personAction = new PersonAction();
            personAction.save(person);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void delete(long id) {
        try {
            PersonAction personAction = new PersonAction();
            personAction.remove(id);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void all() {
        try {
            PersonAction personAction = new PersonAction();
            List<Person> personList = personAction.show();
            for (Person person : personList) {
                System.err.println("Id: " + person.getId());
                System.err.println("First Name: " + person.getFirstName());
                System.err.println("Last Name: " + person.getLastName());
                System.err.println("National Code: " + person.getNationalCode());
                System.err.println("Age: " + person.getAge());
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
