package singleton;

public class Main {

    public static void main(String[] args) {

        SingletonPattern obj = SingletonPattern.getObject();
        SingletonPattern obj2 = SingletonPattern.getObject();
        SingletonPattern obj3 = SingletonPattern.getObject();
        SingletonPattern obj4 = SingletonPattern.getObject();

//        SingletonPattern obj5 = new SingletonPattern();

        System.out.println(obj + " " + obj2 + " " + obj3 + " " + obj4);

    }
}
