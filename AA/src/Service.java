import Notepad.Note;
import Profile.Profile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Service {
    static private ArrayList<Profile> users;

    static public void createNewProfile(String name){
        for(Profile p: users){
            if(p.getName().equals(name)){
                System.out.println("This name is already used!");
                return;
            }
        }
        users.add(new Profile(name));
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

    static public void addTask(Profile user, String title, LocalDateTime time, Boolean repeat,
                               String repeat_time, StringBuilder text){
        Note note = new Note(text);

    }





}
