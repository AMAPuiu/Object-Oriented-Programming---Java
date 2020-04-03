import Notepad.Note;
import Profile.Profile;
import Website.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String [] args) {
        Service service = new Service();

        Service.createNewProfile("Ana");
        Profile myUser = Service.searchUser("Ana");
        System.out.println("Weather");
        Service.addLocation(myUser,"Sibiu",
                "https://www.accuweather.com/ro/ro/sibiu/290499/daily-weather-forecast/290499");
        Service.addLocation(myUser, "Bucuresti",
                "https://www.accuweather.com/ro/ro/bucharest/287430/weather-forecast/287430");
        Service.printLocations(myUser);
        //Service.displayWeather(myUser, "Sibiu");
        Service.removeLocation(myUser, "Bucuresti");
        Service.printLocations(myUser);
        Service.editLocationURL(myUser, "Sibiu", "https://vremea.ido.ro/Sibiu.htm");

        System.out.println("URLs");
        Service.addFreqURL(myUser, "news", "https://www.digi24.ro/");
        Service.addFreqURL(myUser, "news", "https://www.realitatea.net/");
        Service.addFreqURL(myUser, "mail", "https://mail.google.com/mail/u/0/?tab=wm&ogbl#inbox");
        Service.printFreqURL(myUser);
        //Service.openFreqURL(myUser, "news");
        //Service.openURL(myUser, "https://www.google.com/");
        Service.deleteFreqURL(myUser, "news", "https://www.realitatea.net/");
        Service.printFreqURL(myUser);

        System.out.println("Notes");
        Service.addNote(myUser, "work", new StringBuilder("alabala"));
        Service.addNote(myUser, "uni", new StringBuilder("online"));
        Service.displayNotes(myUser);
        Service.editNote(myUser, "uni", new StringBuilder("sad"));
        Service.displayNote(myUser, "uni");
        Service.deleteNote(myUser, "uni");
        Service.displayNotes(myUser);

        System.out.println("Tasks");
        Service.addTask(myUser, "work", LocalDateTime.now(), false, "never", new Note("uni", new StringBuilder("cry")));
        Service.addTask(myUser, "uni", LocalDateTime.now(), false, "never", new Note("uni", new StringBuilder("work")));
        Service.displayTasks(myUser);
        Service.editTask(myUser, "work", LocalDateTime.now(), true, "monthly", new Note("uni", new StringBuilder("cry")));
        Service.displayTask(myUser, "work");
        Service.accomplishedTask(myUser, "work");
        Service.deleteTask(myUser, "uni");
        Service.displayTasks(myUser);

        System.out.println("Shopping Lists");
        HashMap<String, Integer> list = new HashMap<>();
        list.put("eggs", 10);
        list.put("bread", 3);
        HashMap<String, Integer> list2 = new HashMap<>();
        list2.put("paracetamol", 2);
        list2.put("triferment", 3);
        Service.addShoppingList(myUser,"food", LocalDateTime.now(),true,"weekly",new Note("food",new StringBuilder("Ask too")),
                list, "Kaufland");
        Service.addShoppingList(myUser,"pills", LocalDateTime.now(),true,"monthly",new Note("pills",new StringBuilder("Ask too")),
                list2, "Farmacia Tei");
        Service.displayShoppingLists(myUser);
        list2.put("cake", 1);
        Service.editShoppingList(myUser, "food", LocalDateTime.of(2020,7, 29, 18, 0),
                false, "never",new Note("birthday", new StringBuilder("21 Baby")),list,"Grace");
        Service.addItemToShoppingList(myUser,"food","butter", 3);
        Service.addItemToShoppingList(myUser,"food","butter", 2);
        Service.addItemToShoppingList(myUser,"food","milk", 1);
        Service.displayShoppingList(myUser, "food");
        Service.deleteItemFromShoppingList(myUser,"food", "milk");
        Service.boughtItemFromShoppingList(myUser,"food","butter",3);
        Service.accomplishedShoppingList(myUser,"pills");
        Service.displayShoppingLists(myUser);
        Service.deleteShoppingList(myUser,"food");

        System.out.println("Reminders");
        Service.addReminder(myUser,"uni", LocalDateTime.now(),false,"never", new Note("uni", new StringBuilder("PAO")));
        Service.addReminder(myUser,"life", LocalDateTime.now(),false,"never", new Note("run", new StringBuilder("2km")));
        Service.displayReminders(myUser);
        Service.editReminder(myUser,"life",LocalDateTime.now(),false,"daily", new Note("run", new StringBuilder("3km")));
        Service.displayReminder(myUser,"life");
        Service.deleteReminder(myUser,"uni");
        Service.displayReminders(myUser);

        System.out.println("Events");
        Service.addEvent(myUser,"ia","Sibiu",LocalDateTime.now(),false,"never");
        Service.addEvent(myUser,"pao","Sibiu",LocalDateTime.now(),false,"monthly");
        Service.displayEvents(myUser);
        Service.editEvent(myUser,"pao","Bucuresti",LocalDateTime.now(), false,"never");
        Service.displayEvent(myUser,"pao");
        Service.deleteEvent(myUser,"ia");
        Service.displayEvents(myUser);

        System.out.println("Appointments");
        Service.addAppointment(myUser,"stomac",LocalDateTime.now(),false, "never","Gheorghe",
                "Bucuresti", new ArrayList<String>(Arrays.asList("bani","a")),"0732", null);
        Service.addAppointment(myUser,"gat",LocalDateTime.now(),false, "never","Salcamii",
                "Bucuresti", null,"0733", null);
        Service.displayAppointments(myUser);
        Service.editAppointment(myUser,"gat",LocalDateTime.now(),false, "never","Salcamii",
                "Bucuresti", new ArrayList<String>(Arrays.asList("bani","a")),"0733", null);
        Service.displayAppointment(myUser,"gat");
        Service.deleteAppointment(myUser,"stomac");
        Service.displayAppointments(myUser);


    }
    public static void menu(){
        System.out.println("Menu");
        System.out.println("Type:");
        System.out.println(" - 'create' to create profile");
        System.out.println(" - 'add [type] ' to add type: location/url/note/task/reminder/event/appointment");
        System.out.println(" - 'remove [type] ' to remove type: location/url/note/task/reminder/event/appointment");
        System.out.println(" - 'edit [type]' to edit type: location/url/note/task/reminder/event/appointment");
        System.out.println(" - 'display all [type]' to display all of type: location/url/note/task/reminder/event/appointment");
        System.out.println(" - 'display [type] [title]' to display type: location/url/note/task/reminder/event/appointment");
        System.out.println(" - 'weather [location]' to Open in browser the URL to a location from preferences");
        System.out.println(" - 'open [t]' to Open URLs of type t");
        System.out.println(" - 'open [url]' to Open in browser the desired url");
    }
}
