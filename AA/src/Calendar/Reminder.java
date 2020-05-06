package Calendar;

import Notepad.Note;
import Utils.CSVSerialization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Calendar implements CSVSerialization {
    private Boolean repeat;
    private String repeatTime;
    private Note text;

    public Reminder(String title, LocalDateTime time, Boolean repeat, String repeatTime, Note text) {
        super(title, time);
        this.repeat = repeat;
        this.repeatTime = repeatTime;
        this.text = text;
    }

    public Reminder() {

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

    public void print(){
        System.out.print(title + " " + time + " " + repeat + " " + repeatTime + " " + done + " ");
        text.print();
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

    @Override
    public String[] getColumns() {
        return new String[]{"title", "time", "note title", "note text", "repeat", "repeatTime", "status"};
    }

    @Override
    public String[] transformToString(String user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String csvTime = time.format(formatter);
        return new String[]{user, title, csvTime, text.getTitle(), String.valueOf(text.getText()),
                String.valueOf(repeat), repeatTime, String.valueOf(done)};
    }

    @Override
    public String transformFromString(String[] data) {
        String user = data[0];
        title = data[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        time = LocalDateTime.parse(data[2], formatter);
        System.out.println("!!!");
        this.setText(new Note());
        text.setTitle(data[3]);
        text.setText(new StringBuilder(data[4]));
        System.out.println("!!!");
        repeat = Boolean.valueOf(data[5]);
        repeatTime = data[6];
        done = Boolean.valueOf(data[7]);
        return user;
    }
}
