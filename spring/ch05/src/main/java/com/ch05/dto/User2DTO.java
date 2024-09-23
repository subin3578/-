package com.ch05.dto;

public class User2DTO {

    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getHp() {
        return hp;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User1DTO{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", hp='" + hp + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
