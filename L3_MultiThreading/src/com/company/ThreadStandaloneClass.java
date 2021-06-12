package com.company;

public class ThreadStandaloneClass extends Thread{

    @Override
    public void run() {
        System.out.println(currentThread());
    }
}
