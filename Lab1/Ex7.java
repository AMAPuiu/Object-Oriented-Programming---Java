
/**
 * Write a description of class Ex1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Ex7
{
   public static void main(String [] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input:");
        int n = myScanner.nextInt();
        int maxfactor = 1;
        int i = 2;
        while(n != 1){
            if(n % i == 0){
                while(n % i == 0){
                    n = n / i;
                }
                if(i > maxfactor)
                    maxfactor = i;
            }
            i = i + 1;
        }
        System.out.println(maxfactor);    
    }
}
