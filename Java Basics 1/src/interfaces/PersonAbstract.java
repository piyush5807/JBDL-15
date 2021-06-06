package interfaces;

import java.util.Random;

public abstract class PersonAbstract {

    int count = 9;

    public abstract int incrementAndReturnAge(int increment);

    public abstract int decrementAndReturnAge(int decrement);

    public int multiplyAndReturnAge(int multiply, int age){

        return age * multiply;
    }

    public static int randomNumber(){
        Random random = new Random();
        return random.nextInt();
    }
}
