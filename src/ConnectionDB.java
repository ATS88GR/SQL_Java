import java.sql.*;

public class ConnectionDB {
    public static Connection con;
    public static Statement statmt;
    public static ResultSet resSet;


    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException {
        con = null;
        Class.forName("org.sqlite.JDBC");  // Загрузка драйвера
        con = DriverManager.getConnection("jdbc:sqlite:SQLThroughJava.s3db"); // Подключение/Создание базы
        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt = con.createStatement();
        statmt.execute(DialogMenu.makeTable());
        /*statmt.execute("CREATE TABLE if not exists 'Departments' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Name' nvarchar(100) NOT NULL UNIQUE CHECK(trim(name)!=''));");
        statmt.execute("CREATE TABLE if not exists 'Doctors' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Name' nvarchar MAX NOT NULL CHECK(trim(name)!=''), 'Premium' money NOT NULL CHECK(premium>=0) DEFAULT 0, 'Salary' money NOT NULL CHECK(salary>0), 'Surname' nvarchar MAX NOT NULL CHECK(trim(name)!=''));");
        statmt.execute("CREATE TABLE if not exists 'DoctorSpecializations' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'DoctorId' INT NOT NULL , 'SpecializationId' INT NOT NULL, FOREIGN KEY (SpecializationId) REFERENCES Specializations (Id), FOREIGN KEY (DoctorId) REFERENCES Doctors (Id));");
        statmt.execute("CREATE TABLE if not exists 'Donations' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'Amount' MONEY NOT NULL CHECK(amount>0) , 'Date' DATE DEFAULT CURRENT_DATE NOT NULL CHECK ('Date'<= CURRENT_DATE), 'DepartmentId' INT NOT NULL, 'SponsorId' INT NOT NULL, FOREIGN KEY (DepartmentId) REFERENCES Departments (Id), FOREIGN KEY (SponsorId) REFERENCES Sponsors (Id));");
        statmt.execute("CREATE TABLE if not exists 'Specializations' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'Name' nvarchar (100) NOT NULL UNIQUE CHECK(trim(name)!='')) ;");
        statmt.execute("CREATE TABLE if not exists 'Sponsors' ('Id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 'Name' NVARCHAR(100) NOT NULL CHECK(trim('name') != '') UNIQUE);");
        statmt.execute("CREATE TABLE if not exists 'Vocations' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'EndDate' DATE NOT NULL CHECK(date('EndDate') > date('StartDate')) , 'StartDate' DATE NOT NULL, 'DoctorId' INT NOT NULL, FOREIGN KEY (DoctorId) REFERENCES Doctors (Id));");
        statmt.execute("CREATE TABLE if not exists 'Wards' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'Name' nvarchar(20) NOT NULL UNIQUE CHECK(trim(name)!=''), 'DepartmentId' INT NOT NULL, FOREIGN KEY (DepartmentId) REFERENCES Departments (Id));");
*/
        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB() throws SQLException
    {                  // вставка    в какую таблицу    в какие поля              что вставлять
        /*statmt.execute("INSERT INTO 'users'          ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users'          ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users'          ('name', 'phone') VALUES ('Masha', 456123); ");*/

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM Departments");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            //String  phone = resSet.getString("phone");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            //System.out.println( "phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        con.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }
}
