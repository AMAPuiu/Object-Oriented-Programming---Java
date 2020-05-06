package Calendar;

import Notepad.Note;
import Utils.CSVSerialization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ShoppingList extends Task implements CSVSerialization {
    private HashMap<String, Integer> list;
    private String place;

    public ShoppingList(String title, LocalDateTime time, Boolean repeat, String repeat_time,
                        Note text, HashMap<String, Integer> list, String place) {
        super(title, time, repeat, repeat_time, text);
        this.list = list;
        this.place = place;
    }

    public ShoppingList() {

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
    public void buyItem(String name, Integer amount){
        if(list.containsKey(name)){
            list.put(name, list.get(name) - amount);
            if(list.get(name) <= 0){
                deleteItem(name);
            }
        }
    }
    public void print(){
        System.out.print(title + " " + time + " " + repeat + " " + repeatTime + " " + place + " ");
        System.out.println(list);
    }
    public Boolean checkEmpty(){
        return list.isEmpty();
    }
    @Override
    public String[] getColumns() {
        return new String[]{"user","title", "time", "note title", "note text", "repeat", "repeatTime", "status", "place"};
    }

    @Override
    public String[] transformToString(String user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String csvTime = time.format(formatter);
        return new String[]{user, title, csvTime, text.getTitle(), String.valueOf(text.getText()),
                String.valueOf(repeat), repeatTime, String.valueOf(done), place};
    }

    @Override
    public String transformFromString(String[] data) {
        String user = data[0];
        title = data[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        time = LocalDateTime.parse(data[2], formatter);
        this.setText(new Note());
        text.setTitle(data[3]);
        text.setText(new StringBuilder(data[4]));
        repeat = Boolean.valueOf(data[5]);
        repeatTime = data[6];
        done = Boolean.valueOf(data[7]);
        place = data[8];
        return user;
    }
}
