
/**
 * Write a description of class Ex4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ex4
{
        public static void main(String[] args) {
            Scanner myNumber = new Scanner(System.in);
            System.out.print("Input: ");
            int number = myNumber.nextInt();
            int factorial = 1;
            int i;
            for(i=1;i<=number;i++)
                factorial *= i;
            
            System.out.println("Factorialul numarului dat este: " + factorial);
        }

}
