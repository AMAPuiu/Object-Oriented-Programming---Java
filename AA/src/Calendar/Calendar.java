package Calendar;

import java.time.LocalDateTime;
import java.util.Scanner;

abstract public class Calendar {
    protected String title;
    protected LocalDateTime time;
    protected Boolean done;

    public Calendar(String title, LocalDateTime time) {
        this.title = title;
        this.time = time;
        done = false;
    }

    public Calendar() {
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

    public void editText(){
        Scanner myScanner = new Scanner(System.in);
        title = myScanner.nextLine();
    }

    abstract void print();

}
