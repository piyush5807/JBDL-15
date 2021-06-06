package functionalInterfaces;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

//      MyInterface object = new MyInterface() {
//          @Override
//          public int test() {
//              return 0;
//          }
//      };


      List<Integer> numbers = Arrays.asList(4, 5, 1, 3, 7, 9, 12, 34, 23, 90);

      collectAllEvenNos(numbers);

      // sum of squares of all even nos = 4^2 +  12^2 + 24^2 + 90^2

      // lambda
//      MyInterface object2 = (a, b) -> {
//          System.out.println("In test function of myInterface");
//          System.out.println(b + "" + a);
//          return a;
//      };
//
//
//      System.out.println(object2.test(1, "test"));
//      System.out.println(object2.test(2, "java"));

  }

  public static void concatenateNumbers(List<Integer> numbers){

      // 1, 2, 3, 4,

      String ans = numbers
              .stream()
              .map(x -> String.valueOf(x))
              .reduce("", (x, y) -> x + y);

      System.out.println(ans);
  }

  public static void calculateSumViaStreams(List<Integer> numbers){

      // 16, 144, 34^2, 8100
      int sum = numbers.stream()
              .filter(x -> x % 2 == 0)
              .map(y -> y * y)
              .reduce(0, (x, y) -> x + y);

      System.out.println(sum);
  }

  public static void calculateSum(List<Integer> numbers){

      // n number, x are even = n + x
      int sum = 0;
      for(int i = 0; i < numbers.size(); i++){
          if(numbers.get(i) % 2 == 0){
              sum += numbers.get(i) * numbers.get(i);
          }
      }
      System.out.println(sum);

  }


  public static void findFirstMultipleOfSix(List<Integer> numbers){

      int ans = -1;
      for(int i=0;i<numbers.size(); i++){
          if(numbers.get(i) % 6 == 0){
              ans = numbers.get(i);
              break;
          }
      }

      System.out.println(ans);
  }

  //  terminal -> intermediate incorrect

  public static void findFirstMultipleOfSixViaStreams(List<Integer> numbers){

      int abc = 9;
      numbers.stream().filter(x -> {
          System.out.println("x = " + x);
          return x % 6 == 0;
      }).map(x -> x + abc).findFirst();
//      Optional<Integer> firstSixMultiple = numbers.stream()
//              .filter(x -> {
//                  System.out.println("x = " + x);
//                  return x % 6 == 0;
//              })
//              .findFirst();

//      int ans = firstSixMultiple.orElse(-1);

//      System.out.println(ans);
  }

  public static void collectAllEvenNos(List<Integer> numbers){

      List<Integer> evenSquares = new ArrayList<>();

//      numbers.parallelStream()
//              .filter(x -> x % 2 == 0)
//              .map(x -> x * x)
//              .forEach(x -> evenSquares.add(x));
//
//      System.out.println(evenSquares);


      evenSquares = numbers.stream()
              .filter(Main::filterCondition)
              .map(x -> x * x)
              .collect(Collectors.toList());

      System.out.println(evenSquares);

  }

  public static boolean filterCondition(int num){
      //
      return true;
  }
}
