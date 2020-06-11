package Database.Repositories;

import Database.Config.DatabaseConfiguration;
import Database.Models.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileRepo {

    public static void CreateTable(){
        String query = "CREATE TABLE IF NOT EXISTS `profiles` (\n" +
                "  `profileId` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(45) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`profileId`)\n" +
                ")";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.execute();
            System.out.println("Successful creation");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void AddProfile(String name){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM profiles WHERE name=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            ResultSet result = stm.executeQuery();
            if(result.next()){
                System.out.println("There is another user with that name!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = "INSERT INTO profiles (`name`) VALUES(?)";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            stm.executeUpdate();
            System.out.println("Successful insertion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Profile GetProfile(int profileId){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM profiles WHERE profileId = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(query);
            stm.setInt(1, profileId);
            ResultSet result = stm.executeQuery();
            if(!result.next())
            {
                return null;
            }
            return new Profile(result.getInt("profileId"), result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Profile GetProfile(String name){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "SELECT * FROM profiles WHERE name = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(query);
            stm.setString(1, name);
            ResultSet result = stm.executeQuery();
            if(!result.next())
            {
                return null;
            }
            return new Profile(result.getInt("profileId"), result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void UpdateProfile(int profileId, String name){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "UPDATE profiles SET name=? WHERE profileId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(2, profileId);
            stm.setString(1, name);
            stm.executeUpdate();
            System.out.println("Successful update");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteProfile(int profileId){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "DELETE from profiles WHERE profileId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, profileId);
            stm.execute();
            System.out.println("Successful deletion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteAllProfiles(){
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String query = "DELETE FROM profiles";
        try {
            PreparedStatement stm = connection.prepareStatement(query);
            stm.execute();
            System.out.println("Successful deletion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
