package Database.Repositories;

import Database.Config.DatabaseConfiguration;
import Database.Models.Note;
import Database.Models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoteRepo {
    public static void CreateTable(){
        String query = "CREATE TABLE IF NOT EXISTS  notes" + "  ( noteId INT(11) NOT NULL AUTO_INCREMENT," +
                "  title VARCHAR(45) DEFAULT NULL, " +
                "  text VARCHAR(45) DEFAULT NULL, " +
                "  PRIMARY KEY (noteId))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.execute();
            System.out.println("Successful creation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void AddNote(String title, String text){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM tasks WHERE title=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, title);
            ResultSet result = stm.executeQuery();
            if(result.next()){
                System.out.println("There is another note with that name!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = "INSERT INTO notes (title, text) VALUES(?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, title);
            stm.setString(2, text);
            stm.executeUpdate();
            System.out.println("Successful insertion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Note GetNote(int noteId){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM notes WHERE noteId = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(query);
            stm.setInt(1, noteId);
            ResultSet result = stm.executeQuery();
            if(!result.next())
            {
                return null;
            }
            Note n = new Note();
            n.setNoteId(noteId);
            n.setText(result.getString("text"));
            n.setTitle(result.getString("title"));
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Note GetNote(String title){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM notes WHERE title = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(query);
            stm.setString(1, title);
            ResultSet result = stm.executeQuery();
            if(!result.next())
            {
                return null;
            }
            Note n = new Note();
            n.setNoteId(result.getInt("noteId"));
            n.setText(result.getString("text"));
            n.setTitle(result.getString("title"));
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void UpdateNote(int taskId, String title, String text){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "UPDATE notes SET title=?, text=? WHERE noteId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, title);
            stm.setString(2, String.valueOf(text));
            stm.setInt(3, taskId);
            stm.executeUpdate();
            System.out.println("Successful update");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteNote(int noteId){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "DELETE from notes WHERE noteId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, noteId);
            stm.execute();
            System.out.println("Successful deletion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteAllNotes(){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "DELETE FROM notes";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.execute();
            System.out.println("Successful deletion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
