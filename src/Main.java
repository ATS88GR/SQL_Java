import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionDB.Conn();
        //Connections.getCon();
        ConnectionDB.CreateDB();
        ConnectionDB.WriteDB();
        ConnectionDB.ReadDB();
        ConnectionDB.CloseDB();
        //DialogMenu.makeTable();
    }
}