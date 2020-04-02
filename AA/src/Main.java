import Notepad.Note;
import Profile.Profile;
import Website.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class Main {
    public static void main(String [] args) {
        Service service = new Service();

        Service.createNewProfile("Ana");
        Profile myUser = Service.getUsers().get(0);
        Service.addLocation(myUser,"Sibiu",
                "https://www.accuweather.com/ro/ro/sibiu/290499/daily-weather-forecast/290499");
        Service.addLocation(myUser, "Bucuresti",
                "https://www.accuweather.com/ro/ro/bucharest/287430/weather-forecast/287430");
        Service.printLocations(myUser);
        Service.displayWeather(myUser, "Sibiu");
        Service.removeLocation(myUser, "Bucuresti");
        Service.printLocations(myUser);
        Service.editLocationURL(myUser, "Sibiu", "https://vremea.ido.ro/Sibiu.htm");

        Service.addFreqURL(myUser, "news", "https://www.digi24.ro/");
        Service.addFreqURL(myUser, "news", "https://www.realitatea.net/");
        Service.addFreqURL(myUser, "mail", "https://mail.google.com/mail/u/0/?tab=wm&ogbl#inbox");
        Service.openFreqURL(myUser, "news");
        Service.openURL(myUser, "https://www.google.com/");
        Service.deleteFreqURL(myUser, "news", "https://www.realitatea.net/");

        Service.addNote(myUser, "work", new StringBuilder("alabala"));
        Service.addNote(myUser, "uni", new StringBuilder("online"));
        Service.editNote(myUser, "uni", new StringBuilder("sad"));
        Service.deleteNote(myUser, "uni");

        Service.addTask(myUser, "work", LocalDateTime.now(), false, "never", new Note("uni", new StringBuilder("cry")));
        Service.editTask(myUser, "work", LocalDateTime.now(), true, "monthly", new Note("uni", new StringBuilder("cry")));
        Service.deleteTask(myUser, "work");









    }
}
