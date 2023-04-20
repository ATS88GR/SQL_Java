import java.util.Scanner;

public class DialogMenu {
    public static Scanner sc = new Scanner(System.in);

    public static String makeTable(){
        int countColumn = 1;
        String tempValue = "";
        String columnsSettings="(";
        System.out.println("Input table name:");
        String tableName = sc.nextLine();
        System.out.println("How many columns in your table?");
        countColumn = Integer.parseInt(sc.nextLine());
        for(int i =0; i<countColumn; i++){
            System.out.println("Input column " + (i+1) + " Name");
            columnsSettings += "'" + sc.nextLine() + "'";
            System.out.println("Which type of data?");
            columnsSettings += " " + sc.nextLine();
            System.out.println("PRIMARY KEY? (y/n)");
            if (sc.nextLine().equals("y")) columnsSettings += " PRIMARY KEY";
            System.out.println("AUTOINCREMENT? (y/n)");
            if (sc.nextLine().equals("y")) columnsSettings += " AUTOINCREMENT";
            System.out.println("Data can be NULL? (y/n)");
            if (sc.nextLine().equals("y")) columnsSettings += " NOT NULL";
            System.out.println("DEFAULT VALUE?");
            tempValue = sc.nextLine();
            if(!tempValue.isEmpty()) columnsSettings+= " DEFAULT " + tempValue;
            System.out.println("Set CHECK conditions");
            tempValue = sc.nextLine();
            if(!tempValue.isEmpty()) columnsSettings+= " CHECK(" + tempValue + ")";
            if (i<countColumn-1) columnsSettings+=",";
            else columnsSettings+=");";
        }
        String createSample = String.format("CREATE TABLE if not exists '%s '" + columnsSettings, tableName);
        System.out.println(createSample);
        return createSample;
    }
}
