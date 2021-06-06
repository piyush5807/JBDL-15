package functionalInterfaces;

@FunctionalInterface
public interface MyInterface {

    int test(int num, String s);

    default int test2(){
        return 0;
    }
//
//    int test4(int num, String s);
//
//    static int test3(){
//
//    }
}
