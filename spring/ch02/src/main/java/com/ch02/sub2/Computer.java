package com.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.Context;

@Component("com")
public class Computer {
    // 필드 주입
    @Autowired
    private CPU cpu;

    private RAM ram;

    // 생성자 주입
    @Autowired
    public Computer(RAM ram){
        this.ram = ram;
    }

    // 세터 주입
    @Autowired
    private SSD ssd;
    public void setSsd(SSD ssd){
        this.ssd = ssd;
    }

    public void show() {
        cpu.show();
        ram.show();
        ssd.show();
    }
}
