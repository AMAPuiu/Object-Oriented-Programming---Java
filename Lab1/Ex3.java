
/**
 * Write a description of class Ex1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Ex3
{
   public static void main(String [] args){
        
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input:");
        int n = myScanner.nextInt();
        int sum = 0;
        for(int i = 0; i<=n; i++){
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        System.out.println("Suma este: " + sum);
        
    }
}
