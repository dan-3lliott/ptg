import java.lang.Class;
import java.sql.*;
import java.lang.*;

public class Database {
    public static Object[][] viewTableContents() {
        Object[][] contents = new Object[5][11];
        return contents;
    }
    public void sqlStatement(String statement) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/dnHbcxGDVx", "dnHbcxGDVx", "QNyBdxwgIA");
            con.createStatement().execute(statement);
            con.close();
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
