package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InvalidProgram {

  public static void main(String[] args) throws InterruptedException {

      List<Integer> numbers = Arrays.asList(10000, 30000, 40000, 25000, 45000, 35000);

      long start = System.currentTimeMillis();
      MyThread[] threads = new MyThread[numbers.size() - 1];
      for(int i = 0; i < numbers.size() - 1; i++){
          threads[i] = new MyThread(numbers.get(i), numbers.get(i+1));
          threads[i].start();
      }

      for(int i = 0; i < threads.length; i++){
          threads[i].join();
      }

      System.out.println("time = " + (System.currentTimeMillis() - start));
  }

  private static class MyThread extends Thread{

      int num1;
      int num2;

      MyThread(int num1, int num2){
          this.num1 = num1;
          this.num2 = num2;
      }

      @Override
      public void run() {
          System.out.println(num1 * num2);
      }
  }
}
