import java.util.Random;
public class rng{
  public static void main(String[]args){
    Random rand = new Random();
    System.out.println(rand.nextInt() % 1000);
  }
}
