package Classes;

public class Person {
    private String name;
    private String surname;
    private int age;
    private long identity_number;
    private String type;

    public Person(){
        name = "";
        surname = "";
        age = 0;
        identity_number = 0;
        type = "";
    }
    public Person(String name, String surname, int age, long identity_number, String type) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.identity_number = identity_number;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public long getIdentity_number() {
        return identity_number;
    }
    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdentity_number(long identity_number) {
        this.identity_number = identity_number;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void display(){
        System.out.print(name + " " + surname + " " + age + " " + identity_number + " " + type);
    }

}
