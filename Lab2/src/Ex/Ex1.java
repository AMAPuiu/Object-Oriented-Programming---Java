package Ex;

import java.util.Scanner;

public class Ex1 {
    public static void main(String [] args){
        int [] v = new int[25];
        Scanner myScanner = new Scanner(System.in);
        int i, x, sum = 0;
        for(i = 0; i < 25; i++){
            x = myScanner.nextInt();
            if(x == -1) break;
            v[i] = x;
            sum += x;
        }
        System.out.println((float)sum/i);
    }
}
