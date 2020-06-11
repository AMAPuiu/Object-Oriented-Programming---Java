package Database.Models;

public class Profile {

    private int profileId;
    private String name;

    public Profile() {
    }

    public Profile(int profileId, String name) {
        this.profileId = profileId;
        this.name = name;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
