package Database.Repositories;

import Database.Config.DatabaseConfiguration;
import Database.Models.Profile;
import Database.Models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskRepo {
    public static void CreateTable(){
        String query = "CREATE TABLE IF NOT EXISTS  tasks" + "  ( taskId INT(11) NOT NULL AUTO_INCREMENT," +
                "  title VARCHAR(45) DEFAULT NULL, " +
                "  time VARCHAR(45) DEFAULT NULL, " +
                "   status VARCHAR(45) DEFAULT NULL, " +
                "   `repeat` VARCHAR(45) DEFAULT NULL, " +
                "  repeatTime VARCHAR(45) DEFAULT NULL, " +
                "  PRIMARY KEY (taskId))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.execute();
            System.out.println("Successful creation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void AddTask(String title, LocalDateTime time, Boolean done, Boolean repeat, String repeatTime){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM tasks WHERE title=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, title);
            ResultSet result = stm.executeQuery();
            if(result.next()){
                System.out.println("There is another task with that name!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = "INSERT INTO tasks (title, time, status, `repeat`, repeatTime) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, title);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String formattedTime = time.format(formatter);
            stm.setString(2, formattedTime);
            stm.setString(3, String.valueOf(done));
            stm.setString(4, String.valueOf(repeat));
            stm.setString(5, repeatTime);
            stm.executeUpdate();
            System.out.println("Successful insertion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Task GetTask(int taskId){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM tasks WHERE taskId = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(query);
            stm.setInt(1, taskId);
            ResultSet result = stm.executeQuery();
            if(!result.next())
            {
                return null;
            }
            Task t = new Task();
            t.setTaskId(taskId);
            t.setTitle(result.getString("title"));
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            t.setTime(LocalDateTime.parse(result.getString("time"), formatter));
            t.setDone(Boolean.valueOf(result.getString("status")));
            t.setRepeat(Boolean.valueOf(result.getString("`repeat`")));
            t.setRepeatTime(result.getString("repeatTime"));
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Task GetTask(String title){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM tasks WHERE title = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(query);
            stm.setString(1, title);
            ResultSet result = stm.executeQuery();
            if(!result.next())
            {
                return null;
            }
            Task t = new Task();
            t.setTaskId(result.getInt("taskId"));
            t.setTitle(title);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            t.setTime(LocalDateTime.parse(result.getString("time"), formatter));
            t.setDone(Boolean.valueOf(result.getString("status")));
            t.setRepeat(Boolean.valueOf(result.getString("repeat")));
            t.setRepeatTime(result.getString("repeatTime"));
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void UpdateTask(int taskId, String title, LocalDateTime time, Boolean done, Boolean repeat, String repeatTime){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "UPDATE tasks SET title=?, time=?, status=?, `repeat`= ?, repeatTime= ? WHERE taskId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, title);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String formattedTime = time.format(formatter);
            stm.setString(2, formattedTime);
            stm.setString(3, String.valueOf(done));
            stm.setString(4, String.valueOf(repeat));
            stm.setString(5, repeatTime);
            stm.setInt(6, taskId);
            stm.executeUpdate();
            System.out.println("Successful update");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteTask(int taskId){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "DELETE from tasks WHERE taskId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, taskId);
            stm.execute();
            System.out.println("Successful deletion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteAllTasks(){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "DELETE FROM tasks";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.execute();
            System.out.println("Successful deletion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
