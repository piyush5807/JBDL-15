package interfaces;

public class Person extends PersonAbstract{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {

        PersonAbstract p = new Person();
        System.out.println(p.multiplyAndReturnAge(20, 2));
//        Person person = new Person();
//
//        person.setAge(10);
//
////        System.out.println(person.incrementAndReturnAge(20));
////
//        System.out.println(person.multiplyAndReturnAge(3, 30));
//
//        System.out.println(person.count);

//        PersonService personService = new PersonService() {
//            @Override
//            public int incrementAndReturnAge(int increment) {
//                System.out.println("In inner class increment function");
//                return 20 + increment;
//            }
//
//            @Override
//            public int decrementAndReturnAge(int decrement) {
//                return 20 - decrement;
//            }
//        };

//        System.out.println(PersonService.multiplyAndReturnAge(30, 4));

//        Person person = new Person();
//
//        person.setAge(10);
//
//        System.out.println(person.incrementAndReturnAge(50));
//
//        System.out.println(personService.incrementAndReturnAge(50));
//
//        PersonAbstract personAbstract = new PersonAbstract() {
//            @Override
//            public int incrementAndReturnAge(int increment) {
//                return 20 + increment;
//            }
//
//            @Override
//            public int decrementAndReturnAge(int decrement) {
//                return 20 - decrement;
//            }
//        };
//
//        System.out.println(personAbstract.randomNumber());
    }


    @Override
    public int incrementAndReturnAge(int increment) {
        System.out.println("In outer class increment function");
        return this.age + increment;
    }

    @Override
    public int decrementAndReturnAge(int decrement) {
        return this.age - decrement;
    }

    @Override
    public int multiplyAndReturnAge(int multiply, int age){
//        return super.multiplyAndReturnAge(multiply, age);
        return multiply * age + 1;
    }
}
