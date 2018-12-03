package com.website.utils;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.Person.Sex;

public class DataWebSiteFake {

  public static void main(String arg[]) {

    Fairy fairy = Fairy.create();
    Person person = fairy.person();

    // Personal details
    String firstName = person.firstName();
    String lastName = person.lastName();
    String middleName = person.middleName();
    String username = person.username();
    int age = person.age();
    Sex sex = person.sex();
    String email = person.email();
    String password = person.password();
    String passportNumber = person.passportNumber();
    String telephoneNumber = person.telephoneNumber();
    
    System.out.println(firstName);
    System.out.println(lastName);
    System.out.println(middleName);
    System.out.println(username);
    System.out.println(age);
    System.out.println(sex);
    System.out.println(email);
    System.out.println(password);
    System.out.println(passportNumber);
    System.out.println(telephoneNumber);
  }
}

