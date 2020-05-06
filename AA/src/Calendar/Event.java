package Calendar;

import Utils.CSVSerialization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Calendar implements CSVSerialization {
    private String location;
    private Boolean repeat;
    private String repeatTime;

    public Event(String text, LocalDateTime time, String location, Boolean repeat, String repeatTime) {
        super(text, time);
        this.location = location;
        this.repeat = repeat;
        this.repeatTime = repeatTime;
    }

    public Event() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getRepeat() {
        return repeat;
    }

    public void setRepeat(Boolean repeat) {
        this.repeat = repeat;
    }

    public String getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(String repeatTime) {
        this.repeatTime = repeatTime;
    }

    public void displayWeather(){
    }

    public void print(){
        System.out.println(title + " " + time + " " + location + " " + repeat + " " + repeatTime + " " + done);
    }

    @Override
    public String[] getColumns() {
        return new String[]{"title", "time", "location", "repeat", "repeatTime", "status"};
    }

    @Override
    public String[] transformToString(String user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String csvTime = time.format(formatter);
        return new String[]{user, title, csvTime, location, String.valueOf(repeat), repeatTime, String.valueOf(done)};
    }

    @Override
    public String transformFromString(String [] data) {
        String user = data[0];
        title = data[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        time = LocalDateTime.parse(data[2], formatter);
        location = data[3];
        repeat = Boolean.valueOf(data[4]);
        repeatTime = data[5];
        done = Boolean.valueOf(data[6]);
        return user;
    }
}
