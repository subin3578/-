package com.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myService") // 디폴트 : 클래스명에서 소문자로
public class MyService {

    public void insert() {
        System.out.println("핵심기능 - insert...");
    }
    public void select(String uid) {
        System.out.println("핵심기능 - select...");
        if(uid.equals("a101")){
            System.out.println("핵심기능 - uid : "+uid);
        } //예외발생
    }
    public void update() {
        System.out.println("핵심기능 - update...");
    }
    public void delete() {
        System.out.println("핵심기능 - delete...");
    }

}
