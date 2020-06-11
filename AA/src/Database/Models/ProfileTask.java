package Database.Models;

public class ProfileTask {

    private int profileId;
    private int taskId;

    public ProfileTask() {
    }

    public ProfileTask(int profileId, int taskId) {
        this.profileId = profileId;
        this.taskId = taskId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
