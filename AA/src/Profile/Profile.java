package Profile;

import Calendar.*;
import Notepad.Note;
import Website.*;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Profile {
    private String name;
    private Integer ID;
    private Weather weather;
    private FrequentURLs frequentURLs;
    private ArrayList<Task> tasks;
    private ArrayList<ShoppingList> shoppingLists;
    private ArrayList<Reminder> reminders;
    private ArrayList<Event> events;
    private ArrayList<Appointment> appointments;
    private ArrayList<Note> notes;
    private static Integer ids = 0;

    public Profile(String name, Integer ID, Weather weather, FrequentURLs frequentURLs, ArrayList<Task> tasks,
                   ArrayList<ShoppingList> shoppingLists, ArrayList<Reminder> reminders,
                   ArrayList<Event> events, ArrayList<Appointment> appointments, ArrayList<Note> notes) {
        this.name = name;
        this.ID = ID;
        this.weather = weather;
        this.frequentURLs = frequentURLs;
        this.tasks = tasks;
        this.shoppingLists = shoppingLists;
        this.reminders = reminders;
        this.events = events;
        this.appointments = appointments;
        this.notes = notes;
        ids += 1;
    }

    public Profile(String name) {
        this.name = name;
        this.ID = ids;
        weather = new Weather();
        frequentURLs = new FrequentURLs();
        tasks = new ArrayList<Task>();
        shoppingLists = new ArrayList<ShoppingList>();
        reminders = new ArrayList<Reminder>();
        events = new ArrayList<Event>();
        appointments = new ArrayList<Appointment>();
        notes = new ArrayList<Note>();
        ids += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public FrequentURLs getFrequentURLs() {
        return frequentURLs;
    }

    public void setFrequentURLs(FrequentURLs frequentURLs) {
        this.frequentURLs = frequentURLs;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(ArrayList<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public static Integer getIds() {
        return ids;
    }

    public static void setIds(Integer ids) {
        Profile.ids = ids;
    }

    public void addTask(String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text){
        for(Task t: tasks){
            if(t.getTitle().equals(title)) {
                System.out.println("There is another task with the same name");
                return;
            }
        }
        tasks.add(new Task(title, time, repeat, repeat_time, text));
        System.out.println("Successful add");
    }
    public void addTask(Task newTask){
        for(Task t: tasks){
            if(t.getTitle().equals(newTask.getTitle())) {
                System.out.println("There is another task with the same name");
                return;
            }
        }
        tasks.add(newTask);
        System.out.println("Successful add");
    }
    public void deleteTask(String title){
        for(Task t: tasks){
            if(t.getTitle().equals(title)) {
                tasks.remove(t);
                System.out.println("Successful removal");
                return;
            }
        }
        System.out.println("Task doesn't exists!");
    }
    public void editTask(String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text, Boolean done){
        for(Task t: tasks){
            if(t.getTitle().equals(title)) {
                t.setTime(time);
                t.setRepeat(repeat);
                t.setRepeat_time(repeat_time);
                t.setText(text);
                t.setDone(done);
                System.out.println("Successful editing");
                return;
            }
        }
        System.out.println("Task doesn't exists!");
    }
    public void accomplishedTask(String title){
        for(Task t: tasks) {
            if (t.getTitle().equals(title)) {
                t.setDone(true);
                t.print();
                tasks.remove(t);
                System.out.println("Congratulations! Task accomplished!");
                return;
            }
        }
        System.out.println("Task doesn't exists!");
    }

    public void addShoppingList(String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                Note text, HashMap<String, Integer> list, String place){
        for(ShoppingList s: shoppingLists){
            if(s.getTitle().equals(title)){
                System.out.println("There is another shopping list with the same name");
                return;
            }
        }
        shoppingLists.add(new ShoppingList(title, time, repeat, repeat_time, text, list, place));
        System.out.println("Successful add");
    }
    public void addShoppingList(ShoppingList newShoppingList){
        for(ShoppingList s: shoppingLists){
            if(s.getTitle().equals(newShoppingList.getTitle())){
                System.out.println("There is another shopping list with the same name");
                return;
            }
        }
        shoppingLists.add(newShoppingList);
        System.out.println("Successful add");
    }
    public void deleteShoppingList(String title){
        for(ShoppingList s: shoppingLists){
            if(s.getTitle().equals(title)){
                shoppingLists.remove(s);
                System.out.println("Successful removal");
                return;
            }
        }
        System.out.println("Shopping list doesn't exists");
    }
    public void editShoppingList(String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                 Note text, HashMap<String, Integer> list, String place){
        for(ShoppingList s: shoppingLists){
            if(s.getTitle().equals(title)){
                s.setTime(time);
                s.setRepeat(repeat);
                s.setRepeat_time(repeat_time);
                s.setText(text);
                s.setList(list);
                s.setPlace(place);
                System.out.println("There is another shopping list with the same name");
                return;
            }
        }
    }
    public void accomplishedShoppingList(String title){
        for(ShoppingList s: shoppingLists){
            if(s.getTitle().equals(title)){
                s.setDone(true);
                s.print();
                shoppingLists.remove(s);
                System.out.println("Congratulations! You bought everything you needed!");
                return;
            }
        }
        System.out.println("Shopping List doesn't exists!");
    }

    public void addToCalendar(ArrayList<Calendar> list, String title, LocalDateTime time, Boolean repeat,
                              String repeat_time, Note text){
        list.getClass()
        for(Calendar iterator: list){
            if(iterator instanceof Task){

            }
        }

    }



}
