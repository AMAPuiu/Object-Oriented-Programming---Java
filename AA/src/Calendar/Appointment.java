package Calendar;

import Notepad.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Appointment extends Task{
    private String name;
    private String office;
    private ArrayList<String> requirements;
    private String phone_number;

    public Appointment(String title, LocalDateTime time, Boolean repeat, String repeat_time,
                       String name, String location, ArrayList<String> requirements, String phone_number, Note text) {
        super(title, time, repeat, repeat_time, text);
        this.name = name;
        this.office = location;
        this.requirements = requirements;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String location) {
        this.office = location;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<String> requirements) {
        this.requirements = requirements;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    @Override
    public void print(){
        System.out.print(title + " " + time + " " + repeat + " " +
                repeat_time + " " + office + " " + name + " " + phone_number + " "+ done + " ");
        System.out.println(requirements);
    }
    public void addRequirement(String r){
        if(!requirements.contains(r)){
            requirements.add(r);
        }
    }
    public void deleteRequirement(String r){
        requirements.remove(r);
    }
}
