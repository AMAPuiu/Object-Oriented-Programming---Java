package Utils;

import java.io.*;

public class Audit {

    public static void writeEntry(String filePath, String user, String action, String timestamp) throws IOException, FileNotFoundException {
        FileWriter csvWriter = new FileWriter(filePath, true);
        csvWriter.append(user);
        csvWriter.append(",");
        csvWriter.append(action);
        csvWriter.append(",");
        csvWriter.append(timestamp);
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }
    public static void printEntries(String filePath){
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(cvsSplitBy);
                System.out.println("Entry [ user = " + entry[0] + ", action = " + entry[1] + " , timestamp =" + entry[2] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
