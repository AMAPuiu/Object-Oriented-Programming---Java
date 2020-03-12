package Classes;

public class Room {
    private String number;
    private String type;
    private int floor;

    public Room() {
        number = "";
        type = "";
        floor = -1;
    }

    public Room(String number, String type, int floor) {
        this.number = number;
        this.type = type;
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    public void display(){
        System.out.print(number + " " + type + " " + floor);
    }
}
