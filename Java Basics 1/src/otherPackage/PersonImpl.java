package otherPackage;

import com.company.Person;

public class PersonImpl extends Person {



    public PersonImpl(int age, String name) {
        super(age, name);
    }



  public static void main(String[] args) {

        PersonImpl personImpl = new PersonImpl(2, "");

        personImpl.age = 2;
  }
}
