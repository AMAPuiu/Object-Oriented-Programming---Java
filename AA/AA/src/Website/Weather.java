package Website;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Weather extends URLOpener {
    private int nr_locations;
    private HashMap<String, URL> locations;

    public Weather() {
        this.locations = new HashMap<String, URL>();
        nr_locations = 0;
    }

    public Weather(HashMap<String, URL>locations) {
        this.locations = locations;
        nr_locations = locations.size();
    }

    public HashMap<String, URL> getLocations() {
        return locations;
    }

    public void setLocations(HashMap<String, URL> locations) {
        this.locations = locations;
    }

    public void addLocation(String city, URL u) {
        locations.put(city, u);
        nr_locations += 1;
    }

    public void deleteLocation(String city){
        locations.remove(city);
    }

    public void editURL(String city, URL u){
        locations.put(city, u);
    }

    public void print(){
        System.out.print("Favourite locations:");
        System.out.println(locations.keySet());
    }

    public void open(String location){
        if(locations.containsKey(location)){
            try {
                    openURL(locations.get(location));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            return;
            }
        System.out.println("Cannot display weather!");

        }
}
