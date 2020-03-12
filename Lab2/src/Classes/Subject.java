package Classes;

public class Subject {
    Room room;
    int noOfStudents;
    Person teacher;

    public Subject(){
        room = new Room();
        noOfStudents = 0;
        teacher = new Person();
    }
    public Subject(Room room, int noOfStudents, Person teacher) {
        this.room = room;
        this.noOfStudents = noOfStudents;
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
    public void display(){
        room.display();
        System.out.print(" " + noOfStudents + " ");
        teacher.display();
    }
}
