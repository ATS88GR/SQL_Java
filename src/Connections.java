import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static Connection con = null;

    public static Connection getCon() {
        String db = "jdbc:sqlite:SQLThroughJava.s3db";
        return conn(db);
    }

    public static Connection getCon(String db) {
        return conn(db);
    }

    private static Connection conn(String db) {
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(db);
            System.out.println("Base connected");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver wasn't implemented");
        } catch (SQLException e) {
            System.out.println("Driver wasn't connected");;
        }
        return null;
    }
}
