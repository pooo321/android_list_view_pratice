package com.example.pone.non_db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pone on 2017/4/12.
 */

public class Member implements Serializable {
    private String name;
    private String age;
    private String sex;
    private String major;


    public Member(String name, String age, String sex, String major) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.major = major;
    }

    @Override
    public String toString() {
        String text = "Name: " + name +
                "\nAge: " + age +
                "\nGender: " + sex +
                "\nMajor: " + major;
        return text;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }


}
