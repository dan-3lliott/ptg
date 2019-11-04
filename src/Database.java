import java.lang.Class;
import java.sql.*;
import java.util.*;

public class Database {
    public static Object[][] viewTableContents() {
        List<Object[]> tableContents = new ArrayList<Object[]>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            ResultSet results = con.createStatement().executeQuery("SELECT * FROM students");
            while (results.next()) {
                tableContents.add(new Object[]{results.getString(5), results.getString(6), results.getString(7),
                        results.getString(8),results.getString(9), results.getBoolean(10), results.getBoolean(11),
                        results.getBoolean(12), results.getString(13), results.getString(14), results.getString(15)});
            }
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        Object[][] contents = new Object[tableContents.size()][11];
        for (int i = 0; i < tableContents.size(); i++) {
            contents[i] = tableContents.get(i);
        }
        return contents;
    }
    public static void executeStatement(String statement) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            con.createStatement().execute(statement);
            con.close();
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
