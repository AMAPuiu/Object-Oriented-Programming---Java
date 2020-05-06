package Utils;

public interface CSVSerialization {
    String [] getColumns(); // returneaza numele coloanelor specifice fiecarei clase pt a putea fi scrise in csv
    String [] transformToString(String user); // transforma atributele unui obiect in array de stringuri
    String transformFromString(String [] data); // updateaza un obiect
}
