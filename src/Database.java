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
                tableContents.add(new Object[]{results.getString("name"), results.getInt("studentNum"), results.getString("eduPlan"),
                        results.getString("college"), results.getString("careerPath"), results.getString("ethnicity"),
                        results.getBoolean("regents"), results.getBoolean("ncaa"), results.getBoolean("firstGen"),
                        results.getString("gender"), results.getString("major"), results.getDouble("gpa")});
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
