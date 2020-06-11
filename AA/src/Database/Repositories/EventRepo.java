package Database.Repositories;

import Database.Config.DatabaseConfiguration;
import Database.Models.Event;
import Database.Models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventRepo {

    public static void CreateTable(){
            String query = "CREATE TABLE IF NOT EXISTS  events" + "  ( eventId INT(11) NOT NULL AUTO_INCREMENT," +
                    "  title VARCHAR(45) DEFAULT NULL, " +
                    "  time VARCHAR(45) DEFAULT NULL, " +
                    "   status VARCHAR(45) DEFAULT NULL, " +
                    "   location VARCHAR(45) DEFAULT NULL, " +
                    "   `repeat` VARCHAR(45) DEFAULT NULL, " +
                    "  repeatTime VARCHAR(45) DEFAULT NULL, " +
                    "  PRIMARY KEY (eventId))";
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            try {
                PreparedStatement stm = connection.prepareStatement(query);
                stm.execute();
                System.out.println("Successful creation");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
        public static void AddEvent(String title, LocalDateTime time, Boolean done, String location,  Boolean repeat, String repeatTime){
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            String query = "SELECT * FROM events WHERE title=?";
            try {
                PreparedStatement stm = connection.prepareStatement(query);
                stm.setString(1, title);
                ResultSet result = stm.executeQuery();
                if(result.next()){
                    System.out.println("There is another event with that name!");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            query = "INSERT INTO events (title, time, status, location, `repeat`, repeatTime) VALUES(?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement stm = connection.prepareStatement(query);
                stm.setString(1, title);
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                String formattedTime = time.format(formatter);
                stm.setString(2, formattedTime);
                stm.setString(3, String.valueOf(done));
                stm.setString(4, location);
                stm.setString(5, String.valueOf(repeat));
                stm.setString(6, repeatTime);
                stm.executeUpdate();
                System.out.println("Successful insertion");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static Event GetEvent(int eventId){
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            String query = "SELECT * FROM events WHERE eventId = ?";
            PreparedStatement stm = null;
            try {
                stm = connection.prepareStatement(query);
                stm.setInt(1, eventId);
                ResultSet result = stm.executeQuery();
                if(!result.next())
                {
                    return null;
                }
                Event t = new Event();
                t.setEventId(eventId);
                t.setTitle(result.getString("title"));
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                t.setTime(LocalDateTime.parse(result.getString("time"), formatter));
                t.setDone(Boolean.valueOf(result.getString("status")));
                t.setLocation(result.getString("location"));
                t.setRepeat(Boolean.valueOf(result.getString("`repeat`")));
                t.setRepeatTime(result.getString("repeatTime"));
                return t;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        public static Event GetEvent(String title){
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            String query = "SELECT * FROM events WHERE title = ?";
            PreparedStatement stm = null;
            try {
                stm = connection.prepareStatement(query);
                stm.setString(1, title);
                ResultSet result = stm.executeQuery();
                if(!result.next())
                {
                    return null;
                }
                Event t = new Event();
                t.setEventId(result.getInt("eventId"));
                t.setTitle(result.getString("title"));
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                t.setTime(LocalDateTime.parse(result.getString("time"), formatter));
                t.setDone(Boolean.valueOf(result.getString("status")));
                t.setLocation(result.getString("location"));
                t.setRepeat(Boolean.valueOf(result.getString("repeat")));
                t.setRepeatTime(result.getString("repeatTime"));
                return t;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        public static void UpdateEvent(int eventId, String title, LocalDateTime time, Boolean done, String location, Boolean repeat, String repeatTime){
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            String query = "UPDATE events SET title=?, time=?, status=?, location=?, `repeat`= ?, repeatTime= ? WHERE eventId=?";
            try {
                PreparedStatement stm = connection.prepareStatement(query);
                stm.setString(1, title);
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                String formattedTime = time.format(formatter);
                stm.setString(2, formattedTime);
                stm.setString(3, String.valueOf(done));
                stm.setString(4, location);
                stm.setString(5, String.valueOf(repeat));
                stm.setString(6, repeatTime);
                stm.setInt(7, eventId);
                stm.executeUpdate();
                System.out.println("Successful update");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void DeleteEvent(int eventId){
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            String query = "DELETE from events WHERE eventId=?";
            try {
                PreparedStatement stm = connection.prepareStatement(query);
                stm.setInt(1, eventId);
                stm.execute();
                System.out.println("Successful deletion");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void DeleteAllEvents(){
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            String query = "DELETE FROM events";
            try {
                PreparedStatement stm = connection.prepareStatement(query);
                stm.execute();
                System.out.println("Successful deletion");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


