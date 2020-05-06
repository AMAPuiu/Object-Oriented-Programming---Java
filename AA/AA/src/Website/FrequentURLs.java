package Website;

import Utils.CSVSerialization;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class FrequentURLs extends URLOpener {
    private HashMap<String, ArrayList<URL>> favourites;
    private int types;

    public FrequentURLs() {
        this.favourites = new HashMap<String, ArrayList<URL>>();
        types = 0;
    }

    public FrequentURLs(HashMap<String, ArrayList<URL>> favourites) {
        this.favourites = favourites;
        types = favourites.size();
    }

    public HashMap<String, ArrayList<URL>> getFavourites() {
        return favourites;
    }

    public void setFavourites(HashMap<String, ArrayList<URL>> favourites) {
        this.favourites = favourites;
    }

    public void addURL(URL u, String type){
        if (favourites.containsKey(type)){
            favourites.get(type).add(u);
            return;
        }
        favourites.put(type, new ArrayList<URL>(){{add(u);}});
    }

    public void deleteURL(URL u, String type){
        if(favourites.containsKey(type)){
            favourites.get(type).remove(u);
        }
    }

    public void print(){
        System.out.println(favourites);
    }
    public void open(String type){
        if(favourites.containsKey(type)){
            for (URL url : favourites.get(type)) {
                try {
                    openURL(url);
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void open(URL u){
        try {
            openURL(u);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
