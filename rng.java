import java.util.Random;
public class rng{
  public static void main(String[]args){
    Random rand = new Random();
    //for(int i =  0; i < 5; i++ ){
    System.out.println(rand.nextInt() % 1000);
    //}
    /* System.out.println();
    rng = new Random(100);//seed of 100 is stored.
    for(int i =  0; i < 5; i++ ){
      System.out.println(rng.nextInt() % 1000);
    }
    */
  }
}
