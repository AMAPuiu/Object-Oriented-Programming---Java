package Database.Models;

public class ProfileEvent {

    private int profileId;
    private int eventId;

    public ProfileEvent() {
    }

    public ProfileEvent(int profileId, int eventId) {
        this.profileId = profileId;
        this.eventId = eventId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
