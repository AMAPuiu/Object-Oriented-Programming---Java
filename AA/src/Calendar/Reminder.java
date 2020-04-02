package Calendar;

import Notepad.Note;
import java.time.LocalDateTime;

public class Reminder extends Calendar{
    private Boolean repeat;
    private String repeat_time;
    private Note text;

    public Reminder(String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text) {
        super(title, time);
        this.repeat = repeat;
        this.repeat_time = repeat_time;
        this.text = text;
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

    public void print(){
        System.out.println(title + " " + time + " " + repeat + " " + repeat_time + " " + done);
    }
    public void displayNote(){
        System.out.println(text);
    }

    public Note getText() {
        return text;
    }

    public void setText(Note text) {
        this.text = text;
    }
}
