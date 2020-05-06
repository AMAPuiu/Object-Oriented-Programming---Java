package Notepad;

import Utils.CSVSerialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Note implements CSVSerialization {
    private String title;
    private StringBuilder text;

    public Note(String title, StringBuilder text) {
        this.text = text;
        this.title = title;
    }

    public Note() {
    }

    public StringBuilder getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }
    public void insertText(String path){
        try {
            text.delete(0,text.length());
            File fin = new File(path);
            Scanner myReader = new Scanner(fin);
            while (myReader.hasNextLine()) {
                text.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        System.out.println(title + " " + text);
    }

    @Override
    public String[] getColumns() {
        return new String[]{"user","note title", "note text"};
    }

    @Override
    public String[] transformToString(String user) {
        return new String[]{user, title, String.valueOf(text)};
    }

    @Override
    public String transformFromString(String[] data) {
        String user = data[0];
        title = data[1];
        text = new StringBuilder(data[2]);
        return user;
    }
}
