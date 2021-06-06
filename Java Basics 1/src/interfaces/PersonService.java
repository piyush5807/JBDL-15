package interfaces;

public interface PersonService {

    int count = 5;

    int incrementAndReturnAge(int increment);

    int decrementAndReturnAge(int decrement);

    static int multiplyAndReturnAge(int multiply, int age){
        return multiply * age;
    }
}
