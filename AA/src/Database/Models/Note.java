package Database.Models;

public class Note {

    private int noteId;
    private String title;
    private String text;

    public Note() {
    }

    public Note(int noteId, String title, String text) {
        this.noteId = noteId;
        this.title = title;
        this.text = text;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
