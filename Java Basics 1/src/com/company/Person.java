package com.company;


import java.util.*;

public class Person {

    private int id;
    protected int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    public int getAge() {
//        return age;
//    }

    public int getId() {
        return id;
    }

//    public void setAge(int age) {
//
//        if(age < 0){
//            return;
//        }
//
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void incrementAgeByOne(){
        System.out.println("In increment function of Person Class");
        this.age++;
    }

    public void functionA(){

    }

    public void functionB(){
        functionA();
    }

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public Person(int age, String name, int temp){
        this.age = age;
        this.name = name;
    }

    public static String getUpperCaseString(String s){
        return s.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.getAge() && person.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Person p1 = new Person(22, "ABC");

        Person p2 = new Person(22, "DEF", 0);

        System.out.println(p1.equals(p2));

        HashMap<Person, Boolean> personHashMap = new HashMap<>();
//
        System.out.println(p1.hashCode() + " " + p2.hashCode());
//
        personHashMap.put(p1, true);
        personHashMap.put(p2, false);
//
//
        System.out.println(personHashMap);


        System.out.println(personHashMap.get(p2));


//        Person person = new Person();
//        person.incrementAgeByOne();
//
//        System.out.println(person.age);


//        List<String> cities = new ArrayList<>();
//        int n = sc.nextInt();
//
//        for(int i = 0; i < n; i++){
//            cities.add(sc.next());
//        }
//
//        for(String city : cities){
//           System.out.println(Person.getUpperCaseString(city));
//        }

        main(4);
    }

    public static void main(int number){
        System.out.println("Got number = " + number);
    }
}
