
import Calendar.*;
import Notepad.Note;
import Profile.Profile;
import Utils.Audit;
import Utils.CSVReader;
import Utils.CSVWriter;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class Service {
    static private ArrayList<Profile> users;
    static private String filePathAudit;
    static private String filePathUsers;
    static private String filePathAppointments;
    static private String filePathEvents;
    static private String filePathReminders;
    static private String filePathShoppingLists;
    static private String filePathTasks;
    static private String filePathNotes;

    public Service(){
        users = new ArrayList<Profile>();
        filePathAudit = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\audit.csv";
        filePathUsers = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\users.csv";
        filePathAppointments = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\appointments.csv";
        filePathEvents = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\events.csv";
        filePathReminders = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\reminders.csv";
        filePathShoppingLists = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\shoppingLists.csv";
        filePathTasks = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\tasks.csv";
        filePathNotes = "C:\\Users\\ANA\\Desktop\\Workshop\\Anul 2 - sem 2\\PAO\\AA\\src\\Utils\\notes.csv";
    }
    static public void createNewProfile(String name) {
        for(Profile p: users){
            if(p.getName().equals(name)){
                System.out.println("This name is already used!");
                return;
            }
        }
        users.add(new Profile(name));
        System.out.println("AAAAAAAAA");
        //Collections.sort(users);
        try {
            Audit.writeEntry(filePathAudit, "", "create new profile", String.valueOf(LocalDateTime.now()));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Audit.writeEntry(filePathAudit, "", "search user", String.valueOf(LocalDateTime.now()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static public void addLocation(Profile user, String city, String path){
        if(users.contains(user)){
            try {
                System.out.println(user.getWeather());
                user.getWeather().addLocation(city, new URL(path));
                Audit.writeEntry(filePathAudit, user.getName(), "add new location", String.valueOf(LocalDateTime.now()));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void removeLocation(Profile user, String city){
        if(users.contains(user)){
            user.getWeather().deleteLocation(city);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "remove location", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editLocationURL(Profile user, String city, String path) {
        if(users.contains(user)){
            try {
                user.getWeather().editURL(city, new URL(path));
                Audit.writeEntry(filePathAudit, user.getName(), "edit location", String.valueOf(LocalDateTime.now()));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void printLocations(Profile user){
        if(users.contains(user)){
            user.getWeather().print();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "print locations", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayWeather(Profile user, String city){
        if(users.contains(user)){
            user.getWeather().open(city);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display weather", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void addFreqURL(Profile user, String type, String path){
        if(users.contains(user)){
            try {
                user.getFrequentURLs().addURL(new URL(path), type);
                Audit.writeEntry(filePathAudit, user.getName(), "add URL", String.valueOf(LocalDateTime.now()));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteFreqURL(Profile user, String type, String path){
        if(users.contains(user)){
            try {
                user.getFrequentURLs().deleteURL(new URL(path), type);
                Audit.writeEntry(filePathAudit, user.getName(), "delete URL", String.valueOf(LocalDateTime.now()));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void openFreqURL(Profile user, String type){
        if(users.contains(user)){
            user.getFrequentURLs().open(type);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "open URL", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void openURL(Profile user, String path){
        if(users.contains(user)){
            try {
                user.getFrequentURLs().open(new URL(path));
                Audit.writeEntry(filePathAudit, user.getName(), "open random URL", String.valueOf(LocalDateTime.now()));
            } catch (MalformedURLException e) {
                System.out.println("Incorrect path!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void printFreqURL(Profile user){
        if(users.contains(user)){
            user.getFrequentURLs().print();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "print URLs", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    static public void addNote(Profile user, String title, StringBuilder text) {
        if (users.contains(user)) {
            user.getNotes().add(new Note(title, text));
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Note", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteNote(Profile user, String title){
        if (users.contains(user)) {
            user.getNotes().removeIf(n -> n.getTitle().equals(title));
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Note", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editNote(Profile user, String title, StringBuilder text){
        if (users.contains(user)) {
            for(Note t: user.getNotes()){
                if(t.getTitle().equals(title)){
                    t.setText(text);
                    System.out.println("Successful editing");
                    try {
                        Audit.writeEntry(filePathAudit, user.getName(), "edit Note", String.valueOf(LocalDateTime.now()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
            System.out.println("Note doesn't exists!");
        }
    }
    static public void displayNotes(Profile user){
        if (users.contains(user)){
            user.printNotes();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Notes", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayNote(Profile user, String title){
        if (users.contains(user)) {
            user.printNote(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Note", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void addTask(Profile user, String title, LocalDateTime time,
                               Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
                user.addTask(new Task(title, time, repeat, repeat_time, text));
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Task", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editTask(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
                user.editTask(title, time, repeat, repeat_time, text);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "edit Task", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteTask(Profile user, String title){
        if (users.contains(user)) {
            user.deleteTask(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Task", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void accomplishTask(Profile user, String title){
        if (users.contains(user)) {
            user.accomplishTask(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "accomplish Task", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayTasks(Profile user){
        if(users.contains(user)) {
            user.printTasks();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Tasks", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayTask(Profile user, String title){
        if(users.contains(user)) {
            user.printTask(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Task", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void addShoppingList(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                       Note text, HashMap<String, Integer> list, String place){
        if (users.contains(user)) {
            user.addShoppingList(new ShoppingList(title, time, repeat, repeat_time, text, list, place));
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editShoppingList(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                        Note text, HashMap<String, Integer> list, String place){
        if (users.contains(user)) {
            user.editShoppingList(title, time, repeat, repeat_time, text, list, place);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "edit Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteShoppingList(Profile user, String title){
        if (users.contains(user)) {
            user.deleteShoppingList(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void accomplishShoppingList(Profile user, String title){
        if (users.contains(user)) {
            user.accomplishShoppingList(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "accomplish Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void addItemToShoppingList(Profile user, String title, String item, Integer amount){
        if(users.contains(user)) {
            user.addItem(title,item,amount);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Item to Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteItemFromShoppingList(Profile user, String title, String item){
        if(users.contains(user)) {
            user.deleteItem(title,item);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Item from Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void buyItemFromShoppingList(Profile user, String title, String item, Integer amount){
        if(users.contains(user)) {
            user.buyItem(title,item,amount);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "buy Item from Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayShoppingLists(Profile user){
        if (users.contains(user)) {
            user.printShoppingLists();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Shopping Lists", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayShoppingList(Profile user, String title){
        if (users.contains(user)) {
            user.printShoppingList(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Shopping List", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void addReminder(Profile user, String title, LocalDateTime time,
                               Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
            user.addReminder(new Reminder(title, time, repeat, repeat_time, text));
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Reminder", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editReminder(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time, Note text){
        if (users.contains(user)) {
            user.editReminder(title, time, repeat, repeat_time, text);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "edit Reminder", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteReminder(Profile user, String title){
        if (users.contains(user)) {
            user.deleteReminder(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Reminder", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayReminders(Profile user){
        if (users.contains(user)) {
            user.printReminders();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Reminders", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayReminder(Profile user, String title){
        if (users.contains(user)) {
            user.printReminder(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Reminders", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void addEvent(Profile user, String title, String location, LocalDateTime time,
                               Boolean repeat, String repeat_time){
        if (users.contains(user)) {
            user.addEvent(title, time, location, repeat, repeat_time);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Event", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editEvent(Profile user, String title, String location, LocalDateTime time,
                                 Boolean repeat, String repeat_time){
        if (users.contains(user)) {
            user.editEvent(title, time, location, repeat, repeat_time);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "edit Event", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteEvent(Profile user, String title){
        if (users.contains(user)) {
            user.deleteEvent(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Event", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayEvents(Profile user){
        if (users.contains(user)) {
            user.printEvents();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Events", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayEvent(Profile user, String title){
        if (users.contains(user)) {
            user.printEvent(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Event", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void addAppointment(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                      String name, String location, ArrayList<String> requirements, String phone_number, Note text){
        if (users.contains(user)) {
            user.addAppointment(title, time, repeat, repeat_time, name, location, requirements, phone_number, text);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "add Appointment", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void editAppointment(Profile user, String title, LocalDateTime time, Boolean repeat, String repeat_time,
                                String name, String location, ArrayList<String> requirements, String phone_number, Note text){
        if (users.contains(user)) {
            user.editAppointment(title, time, repeat, repeat_time, name, location, requirements, phone_number, text);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "edit Appointment", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void deleteAppointment(Profile user, String title){
        if (users.contains(user)) {
            user.deleteAppointment(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "delete Appointment", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayAppointments(Profile user){
        if (users.contains(user)) {
            user.printAppointments();
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Appointments", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static public void displayAppointment(Profile user, String title){
        if (users.contains(user)) {
            user.printAppointment(title);
            try {
                Audit.writeEntry(filePathAudit, user.getName(), "display Appointments", String.valueOf(LocalDateTime.now()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void parser(StringBuilder option){

    }

    static public void loadUsers() {
        try {
            BufferedReader profileReader = new BufferedReader(new FileReader(filePathUsers));
            CSVReader<Profile> profileCSVReader = new CSVReader<>(profileReader, new Profile());
            while(profileCSVReader.hasEntries()){
                Profile user = new Profile();
                String u = profileCSVReader.readEntry(user);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadAppointments(){
        try {
            BufferedReader appointmentReader = new BufferedReader(new FileReader(filePathAppointments));
            CSVReader<Appointment> appointmentCSVReader = new CSVReader<>(appointmentReader, new Appointment());
            while(appointmentCSVReader.hasEntries()){
                Appointment appointment = new Appointment();
                String userName = appointmentCSVReader.readEntry(appointment);
                Profile user =  searchUser(userName);
                assert user != null;
                user.addAppointment(appointment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadEvents(){
        try {
            BufferedReader eventReader = new BufferedReader(new FileReader(filePathEvents));
            CSVReader<Event> eventCSVReader = new CSVReader<>(eventReader, new Event());
            while(eventCSVReader.hasEntries()){
                Event event = new Event();
                String userName = eventCSVReader.readEntry(event);
                Profile user =  searchUser(userName);
                assert user != null;
                user.addEvent(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadReminders(){
        try {
            BufferedReader reminderReader = new BufferedReader(new FileReader(filePathReminders));
            CSVReader<Reminder> reminderCSVReader = new CSVReader<>(reminderReader, new Reminder());
            while(reminderCSVReader.hasEntries()){
                Reminder reminder = new Reminder();
                String userName = reminderCSVReader.readEntry(reminder);
                Profile user =  searchUser(userName);
                assert user != null;
                user.addReminder(reminder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadShoppingLists(){
        try {
            BufferedReader shoppingListReader = new BufferedReader(new FileReader(filePathShoppingLists));
            CSVReader<ShoppingList> shoppingListCSVReader = new CSVReader<>(shoppingListReader, new ShoppingList());
            while(shoppingListCSVReader.hasEntries()){
                ShoppingList shoppingList = new ShoppingList();
                String userName = shoppingListCSVReader.readEntry(shoppingList);
                Profile user =  searchUser(userName);
                assert user != null;
                user.addShoppingList(shoppingList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadTasks(){
        try {
            BufferedReader tasksListReader = new BufferedReader(new FileReader(filePathTasks));
            CSVReader<Task> taskCSVReader = new CSVReader<>(tasksListReader, new Task());
            while(taskCSVReader.hasEntries()){
                Task task = new Task();
                String userName = taskCSVReader.readEntry(task);
                Profile user =  searchUser(userName);
                assert user != null;
                user.addTask(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadNotes(){
        try {
            BufferedReader notesListReader = new BufferedReader(new FileReader(filePathNotes));
            CSVReader<Note> noteCSVReader = new CSVReader<>(notesListReader, new Note());
            while(noteCSVReader.hasEntries()){
                Note note = new Note();
                String userName = noteCSVReader.readEntry(note);
                Profile user =  searchUser(userName);
                assert user != null;
                user.addNote(note);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void loadData(){
        loadUsers();
        loadAppointments();
        loadEvents();
        loadNotes();
        loadReminders();
        loadShoppingLists();
        loadTasks();
    }
    static public void updateData(){
        updateUsers();
        updateAppointments();
        updateEvents();
        updateNotes();
        updateReminders();
        updateShoppingLists();
        updateTasks();
    }
    static public void updateUsers(){
        try {
            BufferedWriter usersWriter = new BufferedWriter(new FileWriter(filePathUsers));
            CSVWriter<Profile> userCSVWriter = new CSVWriter<Profile>(usersWriter, new Profile());
            for(Profile u: users){
                userCSVWriter.writeObject(u, u.getName());
            }
            usersWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void updateAppointments(){
        try {
            BufferedWriter appointmentsWriter = new BufferedWriter(new FileWriter(filePathAppointments));
            CSVWriter<Appointment> appointmentCSVWriter = new CSVWriter<Appointment>(appointmentsWriter, new Appointment());
            for(Profile u: users){
                for(Appointment a: u.getAppointments()){
                    appointmentCSVWriter.writeObject(a, u.getName());
                }
            }
            appointmentsWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void updateEvents(){
        try {
            BufferedWriter eventsWriter = new BufferedWriter(new FileWriter(filePathEvents));
            CSVWriter<Event> eventCSVWriter = new CSVWriter<Event>(eventsWriter, new Event());
            for(Profile u: users){
                for(Event e: u.getEvents()){
                    eventCSVWriter.writeObject(e, u.getName());
                }
            }
            eventsWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void updateNotes(){
        try {
            BufferedWriter notesWriter = new BufferedWriter(new FileWriter(filePathNotes));
            CSVWriter<Note> noteCSVWriter = new CSVWriter<Note>(notesWriter, new Note());
            for(Profile u: users){
                for(Note n: u.getNotes()){
                    noteCSVWriter.writeObject(n, u.getName());
                }
            }
            notesWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void updateReminders(){
        try {
            BufferedWriter remindersWriter = new BufferedWriter(new FileWriter(filePathReminders));
            CSVWriter<Reminder> reminderCSVWriter = new CSVWriter<Reminder>(remindersWriter, new Reminder());
            for(Profile u: users){
                for(Reminder r: u.getReminders()){
                    reminderCSVWriter.writeObject(r, u.getName());
                }
            }
            remindersWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void updateShoppingLists(){
        try {
            BufferedWriter shoppingListsWriter = new BufferedWriter(new FileWriter(filePathShoppingLists));
            CSVWriter<ShoppingList> shoppingListCSVWriter = new CSVWriter<ShoppingList>(shoppingListsWriter, new ShoppingList());
            for(Profile u: users){
                for(ShoppingList s: u.getShoppingLists()){
                    shoppingListCSVWriter.writeObject(s, u.getName());
                }
            }
            shoppingListsWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void updateTasks(){
        try {
            BufferedWriter tasksWriter = new BufferedWriter(new FileWriter(filePathTasks));
            CSVWriter<Task> taskCSVWriter = new CSVWriter<Task>(tasksWriter, new Task());
            for(Profile u: users){
                for(Task t: u.getTasks()){
                    taskCSVWriter.writeObject(t, u.getName());
                }
            }
            tasksWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
