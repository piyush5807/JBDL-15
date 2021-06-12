package com.company;

public class ThreadByRunnable {

  public static void main(String[] args) {

      ThreadByRunnable object = new ThreadByRunnable();
      MyThread myThread = object.new MyThread();
      Thread thread = new Thread(myThread);
      thread.start();
  }

  private class MyThread implements Runnable{

      @Override
      public void run() {
          System.out.println("current thread - " + Thread.currentThread());
      }
  }
}
