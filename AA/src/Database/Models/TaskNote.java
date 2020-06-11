package Database.Models;

public class TaskNote {
    private int taskId;
    private int noteId;

    public TaskNote() {
    }

    public TaskNote(int taskId, int noteId) {
        this.taskId = taskId;
        this.noteId = noteId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
}
