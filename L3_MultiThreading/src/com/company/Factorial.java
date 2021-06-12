package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Factorial {

  // list of numbers = [10000, 30000, 40000, 5000, 20000, 70000]

  public static void main(String[] args) {

      List<Integer> numbers = Arrays.asList(10000, 30000, 40000, 25000, 45000, 35000);

      long start = System.currentTimeMillis();
      numbers.stream().map(Factorial::getFactorial).forEach(System.out::println);

      System.out.println("time = " + (System.currentTimeMillis() - start));

  }

  public static BigInteger getFactorial(int number){

      BigInteger result = BigInteger.ONE;

      for(int i = 2; i <= number; i++){
          result = result.multiply(BigInteger.valueOf(i));
      }

      return result;
  }
}
