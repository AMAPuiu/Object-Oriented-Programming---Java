package Database.Models;

public class ProfileNote {
    private int profileId;
    private int noteId;

    public ProfileNote() {
    }

    public ProfileNote(int profileId, int noteId) {
        this.profileId = profileId;
        this.noteId = noteId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
}
