import Website.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String [] args) {
        /*FrequentURLs f = new FrequentURLs();
        try {
            f.addURL(new URL("https://mail.google.com/mail/u/0/?tab=wm&ogbl#inbox"), "mail");
            f.print();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        f.open("mail");
        try {
            f.deleteURL(new URL("https://mail.google.com/mail/u/0/?tab=wm&ogbl#inbox"), "mail");
            f.print();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        Weather w = new Weather();
        try {
            w.addLocation("Sibiu", new URL("https://www.accuweather.com/ro/ro/sibiu/290499/daily-weather-forecast/290499"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        w.print();
        w.open("Sibiu");
        w.deleteLocation("Sibiu");
        w.print();

    }
}
