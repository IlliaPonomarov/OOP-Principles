package com.company.People;

import com.company.Interface.InteractionCustomersManager;

public abstract class Person implements InteractionCustomersManager {

    private String first_name;
    private String second_name;
    private int age;


    public Person(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120)
            this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        if (first_name.length() > 1)
            this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        if (second_name.length() > 1)
            this.second_name = second_name;
    }


    public abstract void greetings(Person person, Person person1) throws InterruptedException;

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", age=" + age +
                '}';
    }
}
