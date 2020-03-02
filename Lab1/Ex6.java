
/**
 * Write a description of class Ex5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ex6
{
    public static void main(String [] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input");
        int x = myScanner.nextInt();
        if(x == 1 || x == 2){
            System.out.println("Al " + x + "-lea numar e: 1");
            return;
        }
        int a,b,c;
        a = b = 1;
        int nr = 3;
        while(nr <= x) {
           c = a + b;
           nr++;
           a=b;
           b=c;
        }
        System.out.println("Al " + x + "-lea numar e: " +  b);
    }
}
