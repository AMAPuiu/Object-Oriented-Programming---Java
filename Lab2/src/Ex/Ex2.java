package Ex;

import Classes.Person;

public class Ex2 {
    public static void main(String [] args){
        Person p1 = new Person("John", "Doe", 24, 1123444, "student");
        Person p2 = new Person("Jane", "Roe", 56, 2233444, "teacher");
        p1.display();
        System.out.println();
        p2.display();
    }
}
