import java.lang.Class;
import java.sql.*;

public class Database {
    public static Object[][] viewTableContents() {
        Object[][] contents = new Object[2][11];
        return contents;
    }
    public static void sqlStatement(String statement) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            con.createStatement().execute(statement);
            con.close();
        }
        catch (Exception e) {
            //javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
