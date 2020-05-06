package Calendar;

import Notepad.Note;
import Utils.CSVSerialization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Appointment extends Task implements CSVSerialization {
    private String name;
    private String office;
    private ArrayList<String> requirements;
    private String phoneNumber;

    public Appointment(String title, LocalDateTime time, Boolean repeat, String repeat_time,
                       String name, String location, ArrayList<String> requirements, String phoneNumber, Note text) {
        super(title, time, repeat, repeat_time, text);
        this.name = name;
        this.office = location;
        this.requirements = requirements;
        this.phoneNumber = phoneNumber;
    }

    public Appointment() {
        super();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void print(){
        System.out.print(title + " " + time + " " + repeat + " " +
                repeatTime + " " + office + " " + name + " " + phoneNumber + " "+ done + " ");
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

    @Override
    public String[] getColumns() {
        return new String[]{"user", "title", "time", "note title", "note text", "repeat", "repeatTime", "status", "name", "office", "phone number"};
    }

    @Override
    public String[] transformToString(String user) {
        print();
        return new String[]{user, title, String.valueOf(time),
                String.valueOf(repeat), repeatTime, String.valueOf(done), name, office, phoneNumber};
    }

    @Override
    public String transformFromString(String[] data) {
        String user = data[0];
        title = data[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        time = LocalDateTime.parse(data[2], formatter);
        text.setTitle(data[3]);
        text.setText(new StringBuilder(data[4]));
        repeat = Boolean.valueOf(data[5]);
        repeatTime = data[6];
        done = Boolean.valueOf(data[7]);
        name = data[8];
        office = data[9];
        phoneNumber = data[10];
        return user;
    }
}
