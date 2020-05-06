package Calendar;

import Notepad.Note;
import Utils.CSVSerialization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task extends Calendar implements CSVSerialization {
    protected Boolean repeat;
    protected String repeatTime;
    protected Note text;

    public Task(String title, LocalDateTime time, Boolean repeat, String repeatTime, Note text) {
        super(title, time);
        this.repeat = repeat;
        this.repeatTime = repeatTime;
        this.text = text;
    }

    public Task() {
        super();
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

    public Note getText() {
        return text;
    }

    public void setText(Note text) {
        this.text = text;
    }

    public void print(){
        System.out.print(title + " " + time + " " + repeat + " " + repeatTime + " " + done + " ");
        text.print();
    }
    public void displayNote(){
        System.out.println(text);
    }

    @Override
    public String[] getColumns() {
        return new String[]{"user", "title", "time", "note title", "note text", "repeat", "repeatTime", "status"};
    }

    @Override
    public String[] transformToString(String user) {
        return new String[]{user, title, String.valueOf(time), text.getTitle(), String.valueOf(text.getText()),
                String.valueOf(repeat), repeatTime, String.valueOf(done)};
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
        return user;
    }
}
