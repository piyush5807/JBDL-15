package singleton;

public class SingletonPattern {

//    private static List<SingletonPattern> objects = new ArrayList<>();

    private static SingletonPattern object = null;

    private String attr1;
    private String attr2;

    private SingletonPattern(){

    }

//    public static SingletonPattern getObject(){
//
//        SingletonPattern obj = null;
//        if(objects.size() < 5){
//            obj = new SingletonPattern();
//            objects.add(obj);
//        }else{
//            obj = objects.get(0);
//        }
//
//        return obj;
//    }

    public static SingletonPattern getObject(){
        if(object == null){
            object = new SingletonPattern();
        }

        return object;
    }

}
