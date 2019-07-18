package com.xchen.entity;

public class Student {
    int stuId;
    String name;
    int age;
    String sex;
    String banji;

    public Student(int stuId, String name, int age, String sex, String banji) {
        this.stuId = stuId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.banji = banji;
    }

    public Student() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }
}
