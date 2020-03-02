
/**
 * Write a description of class Ex5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ex5
{
    public static void main(String [] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input:");
        int x = myScanner.nextInt();
        int i;
        if(x == 0 || x == 1) {
                System.out.println(false);
                return;
            }
        if (x == 2)
            {
                System.out.println(true);
                return;
            }
        if (x % 2 == 0) {
                System.out.println(false);
                return;
            }
        for(i=3 ; i*i<=x ; i+=2)
            {
                if (x%i == 0){
                    System.out.println(false);
                    return;
                }
            }
        System.out.println(true);
    }
}
