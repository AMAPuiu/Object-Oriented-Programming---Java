package Ex;

import Classes.Person;
import Classes.Room;
import Classes.Subject;

public class Ex4 {
    public static void main(String [] args){
        Person p1 = new Person("John", "Doe", 24, 1123444, "teacher");
        Person p2 = new Person("Jane", "Roe", 56, 2233444, "teacher");
        Room r1 = new Room("12A", "normal",3);
        Room r2 = new Room("12B", "tech", 7);
        Subject s1 = new Subject(r1, 10, p1);
        Subject s2 = new Subject(r2, 20, p2);
        s1.display();
        System.out.println();
        s2.display();

    }
}
