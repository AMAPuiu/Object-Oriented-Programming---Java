import Calendar.Event;
import Calendar.Reminder;
import Calendar.ShoppingList;
import Calendar.Task;
import Notepad.Note;
import Profile.Profile;
import org.jetbrains.annotations.Nullable;

import javax.lang.model.type.NullType;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class Service {
    static private ArrayList<Profile> users;

    public Service(){
        users = new ArrayList<Profile>();
    }
    static public void createNewProfile(String name){
        for(Profile p: users){
            if(p.getName().equals(name)){
                System.out.println("This name is already used!");
                return;
            }
        }
        users.add(new Profile(name));
        System.out.println("AAAAAAAAA");
        //Collections.sort(users);
    }

    public static ArrayList<Profile> getUsers() {
        return users;
    }
    @Nullable
    public static Profile searchUser(String name){
        for(Profile p: users){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }
    static public void addLocation(Profile user, String city, String path){
        if(users.contains(user)){
            try {
                user.getWeather().addLocation(city, new URL(path));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            }
        }
    }
    static public void removeLocation(Profile user, String city){
        if(users.contains(user)){
            user.getWeather().deleteLocation(city);
        }
    }
    static public void editLocationURL(Profile user, String city, String path) {
        if(users.contains(user)){
            try {
                user.getWeather().editURL(city, new URL(path));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            }
        }
    }
    static public void printLocations(Profile user){
        if(users.contains(user)){
            user.getWeather().print();
        }
    }
    static public void displayWeather(Profile user, String city){
        if(users.contains(user)){
            user.getWeather().open(city);
        }
    }

    static public void addFreqURL(Profile user, String type, String path){
        if(users.contains(user)){
            try {
                user.getFrequentURLs().addURL(new URL(path), type);
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            }
        }
    }
    static public void deleteFreqURL(Profile user, String type, String path){
        if(users.contains(user)){
            try {
                user.getFrequentURLs().deleteURL(new URL(path), type);
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            }
        }
    }
    static public void openFreqURL(Profile user, String type){
        if(users.contains(user)){
            user.getFrequentURLs().open(type);
        }
    }
    static public void openURL(Profile user, String path){
        if(users.contains(user)){
            try {
                user.getFrequentURLs().open(new URL(path));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            }
        }
    }
    static public void printFreqURL(Profile user){
        if(users.contains(user)){
            user.getFrequentURLs().print();
        }
    }



    static public void addNote(Profile user, String title, StringBuilder text) {
        if (users.contains(user)) {
            user.getNotes().add(new Note(title, text));
        }
    }
    static public void deleteNote(Profile user, String title){
        if (users.contains(user)) {
            user.getNotes().removeIf(n -> n.getTitle().equals(title));
        }
    }
    static public void editNote(Profile user, String title, StringBuilder text){
        if (users.contains(user)) {
            for(Note t: user.getNotes()){
                if(t.getTitle().equals(title)){
                    t.setText(text);
                    System.out.println("Successful editing");
                    return;
                }
            }
            System.out.println("Note doesn't exists!");
        }
    }
    static public void displayNotes(Profile user){
        if (users.contains(user))
            user.printNotes();
    }
    static public void displayNote(Profile user, String title){
        if (users.contains(user))
            user.printNote(title);
    }

    static public void addTask(Profile user, String title, LocalDateTime time,
                               Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
                user.addTask(new Task(title, time, repeat, repeat_time, text));
        }
    }
    static public void editTask(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
                user.editTask(title, time, repeat, repeat_time, text);
        }
    }
    static public void deleteTask(Profile user, String title){
        if (users.contains(user)) {
            user.deleteTask(title);
        }
    }
    static public void accomplishedTask(Profile user, String title){
        if (users.contains(user)) {
            user.accomplishedTask(title);
        }
    }
    static public void displayTasks(Profile user){
        if(users.contains(user))
            user.printTasks();
    }
    static public void displayTask(Profile user, String title){
        if(users.contains(user))
            user.printTask(title);
    }

    static public void addShoppingList(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                       Note text, HashMap<String, Integer> list, String place){
        if (users.contains(user)) {
            user.addShoppingList(new ShoppingList(title, time, repeat, repeat_time, text, list, place));
        }
    }
    static public void editShoppingList(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                        Note text, HashMap<String, Integer> list, String place){
        if (users.contains(user)) {
            user.editShoppingList(title, time, repeat, repeat_time, text, list, place);
        }
    }
    static public void deleteShoppingList(Profile user, String title){
        if (users.contains(user)) {
            user.deleteShoppingList(title);
        }
    }
    static public void accomplishedShoppingList(Profile user, String title){
        if (users.contains(user)) {
            user.accomplishedShoppingList(title);
        }
    }
    static public void addItemToShoppingList(Profile user, String title, String item, Integer amount){
        if(users.contains(user)) {
            user.addItem(title,item,amount);
        }
    }
    static public void deleteItemFromShoppingList(Profile user, String title, String item){
        if(users.contains(user)) {
            user.deleteItem(title,item);
        }
    }
    static public void boughtItemFromShoppingList(Profile user, String title, String item, Integer amount){
        if(users.contains(user)) {
            user.boughtItem(title,item,amount);
        }
    }
    static public void displayShoppingLists(Profile user){
        if (users.contains(user)) {
            user.printShoppingLists();
        }
    }
    static public void displayShoppingList(Profile user, String title){
        if (users.contains(user)) {
            user.printShoppingList(title);
        }
    }

    static public void addReminder(Profile user, String title, LocalDateTime time,
                               Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
            user.addReminder(new Reminder(title, time, repeat, repeat_time, text));
        }
    }
    static public void editReminder(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
            user.editReminder(title, time, repeat, repeat_time, text);
        }
    }
    static public void deleteReminder(Profile user, String title){
        if (users.contains(user)) {
            user.deleteReminder(title);
        }
    }
    static public void displayReminders(Profile user){
        if (users.contains(user)) {
            user.printReminders();
        }
    }
    static public void displayReminder(Profile user, String title){
        if (users.contains(user)) {
            user.printReminder(title);
        }
    }

    static public void addEvent(Profile user, String title, String location, LocalDateTime time,
                               Boolean repeat, String repeat_time){
        if (users.contains(user)) {
            user.addEvent(title, time, location, repeat, repeat_time);
        }
    }
    static public void editEvent(Profile user, String title, String location, LocalDateTime time,
                                 Boolean repeat, String repeat_time){
        if (users.contains(user)) {
            user.editEvent(title, time, location, repeat, repeat_time);
        }
    }
    static public void deleteEvent(Profile user, String title){
        if (users.contains(user)) {
            user.deleteEvent(title);
        }
    }
    static public void displayEvents(Profile user){
        if (users.contains(user)) {
            user.printEvents();
        }
    }
    static public void displayEvent(Profile user, String title){
        if (users.contains(user)) {
            user.printEvent(title);
        }
    }

    static public void addAppointment(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                      String name, String location, ArrayList<String> requirements, String phone_number, Note text){
        if (users.contains(user)) {
            user.addAppointment(title, time, repeat, repeat_time, name, location, requirements, phone_number, text);
        }
    }
    static public void editAppointment(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                String name, String location, ArrayList<String> requirements, String phone_number, Note text){
        if (users.contains(user)) {
            user.editAppointment(title, time, repeat, repeat_time, name, location, requirements, phone_number, text);
        }
    }
    static public void deleteAppointment(Profile user, String title){
        if (users.contains(user)) {
            user.deleteAppointment(title);
        }
    }
    static public void displayAppointments(Profile user){
        if (users.contains(user)) {
            user.printAppointments();
        }
    }
    static public void displayAppointment(Profile user, String title){
        if (users.contains(user)) {
            user.printAppointment(title);
        }
    }

    static public void parser(StringBuilder option){

    }


}
