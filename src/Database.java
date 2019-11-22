import java.lang.Class;
import java.sql.*;
import java.util.*;

public class Database {
    public static Object[][] viewTableContents() { //pulls only student data that is present in the table
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
    public static List<Object[]> classes() { //returns all of the classes present in the database
        List<List<Object>> dbClasses = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            dbClasses.add(new ArrayList<>());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            ResultSet results = con.createStatement().executeQuery("SHOW COLUMNS FROM students");
            int i = 0;
            while (results.next()) {
                if (i > 16) { //skip past student information to class columns
                    String s = results.getString(1);
                    dbClasses.get(Arrays.asList(Main.periods).indexOf(s.substring(s.indexOf("_") + 1))).add(s.substring(0, s.indexOf("_")));
                }
                i++;
            }
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        List<Object[]> classes = new ArrayList<>();
        for (int i = 0; i < dbClasses.size(); i++) {
            classes.add(dbClasses.get(i).toArray());
        }
        return classes;
    }
    public static Object[] studentData(int studentNum) { //pull all data on student, used by EditWindow
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
    public static void executeStatement(String statement) { //general executeStatement method used primarily for pushing data into db
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            con.prepareStatement(statement).execute(); //preparedStatement helps prevent against SQL injection
            con.close();
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
