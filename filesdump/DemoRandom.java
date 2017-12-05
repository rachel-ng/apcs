import java.util.Random;
public class DemoRandom{
  public static void main(String[]args){
    Random rng = new Random();
    for(int i =  0; i < 5; i++ ){
      System.out.println(rng.nextInt() % 1000);
    }
    System.out.println();
    rng = new Random(100);//seed of 100 is stored.
    for(int i =  0; i < 5; i++ ){
      System.out.println(rng.nextInt() % 1000);
    }
  }
}
