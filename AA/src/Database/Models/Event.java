package Database.Models;

import java.time.LocalDateTime;

public class Event {

    private int eventId;
    protected String title;
    protected LocalDateTime time;
    protected Boolean done;
    private String location;
    private Boolean repeat;
    private String repeatTime;

    public Event() {
    }

    public Event(int eventId, String title, LocalDateTime time, Boolean done, String location, Boolean repeat, String repeatTime) {
        this.eventId = eventId;
        this.title = title;
        this.time = time;
        this.done = done;
        this.location = location;
        this.repeat = repeat;
        this.repeatTime = repeatTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
