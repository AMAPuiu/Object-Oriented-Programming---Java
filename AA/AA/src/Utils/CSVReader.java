package Utils;

import javax.lang.model.type.NullType;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVReader<T extends CSVSerialization> {
    private BufferedReader reader;

    public CSVReader(BufferedReader reader, T object) throws IOException {
        this.reader = reader;
        if (object != null) {
            String header = reader.readLine();
            System.out.println(header);
            if(header != null && !header.equals("")){
                String[] columns = header.split(",");
                boolean headersAreTheSame = Arrays.equals(columns, object.getColumns());
                if (!headersAreTheSame) {
                    throw new RuntimeException("headers of CSV file do not match");
                }
            }}
    }
    public boolean hasEntries() throws IOException {
        return reader.ready();
    }

    public String readEntry(T object) throws IOException {
        String line = reader.readLine();
        String[] values = line.split(",");
        return object.transformFromString(values);
    }
}
