
/**
 * Write a description of class Ex1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Ex2
{
   public static void main(String [] args){        
       Scanner myScanner = new Scanner(System.in);
       System.out.println("User Input");
       System.out.print("Input first integer:");
       int nr1 = myScanner.nextInt();
       System.out.print("Input second integer:");
       int nr2 = myScanner.nextInt();
       System.out.println("Expected Output:");
       if(nr1 == nr2)
       System.out.println(nr1 + "==" + nr2);
       else {
        System.out.println(nr1 + "!=" + nr2);
        if(nr1<nr2){
            System.out.println(nr1 + "<" + nr2);
            System.out.println(nr1 + "<=" + nr2);
        }
        else {
            System.out.println(nr1 + ">" + nr2);
            System.out.println(nr1 + ">=" + nr2);
        }
        
        }
        
    }
}
