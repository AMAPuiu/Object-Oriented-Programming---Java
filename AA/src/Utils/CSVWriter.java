package Utils;

import java.io.BufferedWriter;
import java.io.IOException;

public class CSVWriter <T extends CSVSerialization> {
    private BufferedWriter writer;

    public CSVWriter(BufferedWriter writer, T object) throws IOException {
        this.writer = writer;
        if (object != null) {
            String[] columns = object.getColumns();
            String header = String.join(",", columns) + '\n';
            writer.write(header);
            writer.flush();
        }
    }

    public void writeObject(T object, String user) throws IOException {
        String[] strings = object.transformToString(user);
        String line = String.join(",", strings) + '\n';
        writer.write(line);
    }
}
