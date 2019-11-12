import java.lang.Class;
import java.sql.*;
import java.util.*;

public class Database {
    public static Object[][] viewTableContents() {
        List<Object[]> tableContents = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            ResultSet results = con.createStatement().executeQuery("SELECT * FROM students");
            while (results.next()) {
                tableContents.add(new Object[]{results.getString("name"), results.getInt("studentNum"), results.getString("eduPlan"),
                        results.getString("college"), results.getString("careerPath"), results.getString("ethnicity"),
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
    public static Object[] classes() {
        List<Object> dbClasses = new ArrayList<>(8);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            ResultSet results = con.createStatement().executeQuery("SHOW COLUMNS FROM students");
            int i = 0;
            while (results.next()) {
                if (i > 16) { //skip past student information to class columns
                    String s = results.getString(1);
                    dbClasses.add(s.substring(0, s.indexOf("_")));
                }
                i++;
            }
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        Object[] classes = new Object[dbClasses.size()];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = dbClasses.get(i);
        }
        return classes;
    }
    public static Object[] studentData(int studentNum) {
        Object[] dbData = new Object[17];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            ResultSet results = con.createStatement().executeQuery("SELECT * FROM students WHERE studentNum = '" + studentNum + "'");
            while (results.next()) {
                dbData = new Object[]{results.getString("name"), results.getInt("studentNum"), results.getString("eduPlan"),
                        results.getString("college"), results.getString("careerPath"), results.getString("ethnicity"),
                        results.getBoolean("regents"), results.getBoolean("ncaa"), results.getBoolean("firstGen"),
                        results.getString("gender"), results.getString("major"), results.getDouble("gpa"),
                        results.getString("notes0"), results.getString("notes1"), results.getString("notes2"),
                        results.getString("notes3"), results.getString("id")};
            }
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dbData;
    }
    public static void executeStatement(String statement) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            con.createStatement().execute(statement);
            con.close();
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
