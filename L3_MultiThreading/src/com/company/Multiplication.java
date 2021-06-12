package com.company;

public class Multiplication {

  public static void main(String[] args) throws InterruptedException {
    // (a+b) * (c+d)

      MyThread thread = new MyThread(10, 20); // 30
      MyThread thread2 = new MyThread(30, 40); // 70

      thread.start();
      thread2.start();

      System.out.println(thread.result * thread2.result);

   }

   private static class MyThread extends Thread{

      int num1, num2, result;

      MyThread(int num1, int num2){
          this.num1 = num1;
          this.num2 = num2;
          this.result = 0;
      }

       @Override
       public void run() {
           this.result = this.num1 + this.num2;
       }
   }
}
