package Calendar;

import java.time.LocalDateTime;

public class Event extends Calendar {
    private String location;
    private Boolean repeat;
    private String repeat_time;

    public Event(String text, LocalDateTime time, String location, Boolean repeat, String repeat_time) {
        super(text, time);
        this.location = location;
        this.repeat = repeat;
        this.repeat_time = repeat_time;
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

    public String getRepeat_time() {
        return repeat_time;
    }

    public void setRepeat_time(String repeat_time) {
        this.repeat_time = repeat_time;
    }

    public void displayWeather(){
    }

    public void print(){
        System.out.println(title + " " + time + " " + location + " " + repeat + " " + repeat_time + " " + done);
    }
}
