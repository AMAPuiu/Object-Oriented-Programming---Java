package Database;


import Database.Config.DatabaseConfiguration;
import Database.Models.Event;
import Database.Models.Note;
import Database.Models.Profile;
import Database.Models.Task;
import Database.Repositories.EventRepo;
import Database.Repositories.NoteRepo;
import Database.Repositories.ProfileRepo;
import Database.Repositories.TaskRepo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Main {
    public static void main(String [] args){
        ProfileRepo.CreateTable();
//        ProfileRepo.AddProfile("Ana");
//        ProfileRepo.AddProfile("Adi");
//        ProfileRepo.AddProfile("Ana");
//        ProfileRepo.UpdateProfile(1, "Maria");
//        Profile p = ProfileRepo.GetProfile("Alex");
//        if(p == null)
//            System.out.println("There is no profile wiith this name!");
//        else System.out.println(p.getName());
//        int profileId = Objects.requireNonNull(ProfileRepo.GetProfile("Ana")).getProfileId();
//        ProfileRepo.DeleteProfile(profileId);
//        ProfileRepo.DeleteAllProfiles();

//        TaskRepo.CreateTable();
//        TaskRepo.AddTask("water", LocalDateTime.now(), false, false,"never");
//        TaskRepo.AddTask("food", LocalDateTime.now(), false, true, "daily");
//        TaskRepo.AddTask("food", LocalDateTime.now(), false, true, "daily");
//        Task t = TaskRepo.GetTask("food");
//        if(t == null)
//            System.out.println("There is no task with that name!");
//        else {
//            System.out.println(t.getTitle());
//            TaskRepo.UpdateTask(t.getTaskId(),"food", LocalDateTime.now(), true, true, "daily");
//
//            TaskRepo.DeleteTask(t.getTaskId());
//        }
//        TaskRepo.DeleteAllTasks();

//        NoteRepo.CreateTable();
//        NoteRepo.AddNote("water", "need");
//        NoteRepo.AddNote("food", "hungry");
//        NoteRepo.AddNote("food", "hungry");
//        Note n = NoteRepo.GetNote("food");
//        if(n == null)
//            System.out.println("There is no note with that name!");
//        else {
//            System.out.println(n.getTitle());
//            NoteRepo.UpdateNote(n.getNoteId(),"food","no more hungry");
//            NoteRepo.DeleteNote(n.getNoteId());
//        }
//        NoteRepo.DeleteAllNotes();

        EventRepo.CreateTable();
        EventRepo.AddEvent("water", LocalDateTime.now(), false, "kitchen", false,"never");
        EventRepo.AddEvent("food", LocalDateTime.now(), false, "kitchen", true, "daily");
        EventRepo.AddEvent("food", LocalDateTime.now(), false, "kitchen", true, "daily");
        Event e = EventRepo.GetEvent("food");
        if(e == null)
            System.out.println("There is no event with that name!");
        else {
            System.out.println(e.getTitle());
            EventRepo.UpdateEvent(e.getEventId(),"food", LocalDateTime.now(),true, "kitchen", true, "daily");

            EventRepo.DeleteEvent(e.getEventId());
        }
        EventRepo.DeleteAllEvents();

        DatabaseConfiguration.closeDatabaseConnection();
    }
}
