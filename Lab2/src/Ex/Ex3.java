package Ex;

import Classes.Room;

public class Ex3 {
    public static void main(String [] args){
        Room r1 = new Room("12A", "normal",3);
        Room r2 = new Room("12B", "tech", 7);
        r1.display();
        System.out.println();
        r2.display();
    }
}
