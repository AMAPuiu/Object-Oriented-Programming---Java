package Database.Models;

import Notepad.Note;

import java.time.LocalDateTime;

public class Task {
    private int taskId;
    private String title;
    private LocalDateTime time;
    private Boolean done;
    private Boolean repeat;
    private String repeatTime;

    public Task() {
    }

    public Task(int taskId, String title, LocalDateTime time, Boolean done, Boolean repeat, String repeatTime) {
        this.taskId = taskId;
        this.title = title;
        this.time = time;
        this.done = done;
        this.repeat = repeat;
        this.repeatTime = repeatTime;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

}
