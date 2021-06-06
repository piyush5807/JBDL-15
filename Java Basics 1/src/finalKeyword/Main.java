package finalKeyword;

public class Main extends Parent{

    // 1. Variables
    // 2. functions
    // 3. class

   final int count;

  int a = 5;
  int b = 5;


  Main(){
      this.count = 20;
  }

  Main(int count){
      this.count = count;
  }

//  static {
//      count = 30;
//  }

    public final void funcC(){
      System.out.println("In func A");
    }

    private void funcD(){
        System.out.println("In func A");
    }

    public void funcB(){
        System.out.println("In func B");
    }

  public static void main(String[] args) {

      Main main = new Main();
  }
}
