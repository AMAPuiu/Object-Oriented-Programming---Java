package Notepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Note {
    private StringBuilder text;

    public Note(StringBuilder text) {
        this.text = text;
    }

    public StringBuilder getText() {
        return text;
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


}
