package Calendar;

import Notepad.Note;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ShoppingList extends Task{
    private HashMap<String, Integer> list;
    private String place;

    public ShoppingList(String title, LocalDateTime time, Boolean repeat, String repeat_time,
                        Note text, HashMap<String, Integer> list, String place) {
        super(title, time, repeat, repeat_time, text);
        this.list = list;
        this.place = place;
    }

    public HashMap<String, Integer> getList() {
        return list;
    }

    public void setList(HashMap<String, Integer> list) {
        this.list = list;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    public void addItem(String name, Integer amount){
        if(list.containsKey(name)){
            list.put(name, list.get(name) + amount);
            return;
        }
        list.put(name, amount);
    }
    public void deleteItem(String name){
        list.remove(name);
    }
    public void boughtItem(String name, Integer amount){
        if(list.containsKey(name)){
            list.put(name, list.get(name) - amount);
            if(list.get(name) <= 0){
                deleteItem(name);
            }
        }
    }
    public Boolean checkEmpty(){
        return list.isEmpty();
    }
}
