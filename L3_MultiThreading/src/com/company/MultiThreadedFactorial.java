package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MultiThreadedFactorial {

  public static void main(String[] args) throws InterruptedException {

      List<Integer> numbers = Arrays.asList(10000, 30000, 40000, 25000, 45000, 35000);

//      List<Integer> numbers = Arrays.asList(4, 3, 2, 5, 6 ,7, 8);
      MyThread[] threads = new MyThread[numbers.size()];

      long start = System.currentTimeMillis();
      IntStream.range(0, numbers.size()).forEach(i -> {

          threads[i] = new MyThread(numbers.get(i));
          threads[i].start();
      });
//
      for(int i = 0; i < threads.length; i++){
          threads[i].join(25);
          System.out.println(threads[i].number + " " + threads[i].result);
      }

      System.out.println("time = " + (System.currentTimeMillis() - start));

//      System.out.println(Runtime.getRuntime().availableProcessors());
  }

  private static class MyThread extends Thread{

      int number;
      BigInteger result;

      MyThread(int number){
          this.number = number;
          this.result = BigInteger.ONE;
      }

      @Override
      public void run() {
          calculate();
      }

      public void calculate(){

          for(int i = 2; i <= number; i++){
              this.result = this.result.multiply(BigInteger.valueOf(i));
          }

      }
  }
}
