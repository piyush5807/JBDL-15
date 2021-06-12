package com.company;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//
//        printRandomNumbers(10);

//        MyThread thread = new MyThread();
        ThreadStandaloneClass thread = new ThreadStandaloneClass();
        thread.start();

        System.out.println(Thread.currentThread());
    }

    private static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println(currentThread());
            testFunc();
        }

        public void testFunc(){
            System.out.println("In test func - "  + currentThread());
        }
    }


//    public static void printRandomNumbers(int n){
//
//        System.out.println(Thread.currentThread());
//        Random random = new Random();
//
//        IntStream.range(0, n).forEach(i -> {
//            System.out.println(random.nextInt());
//        });
//    }
}
