import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;

public class ViewPanel extends JPanel {
    //variable declaration
    private DefaultTableModel studentModel = new DefaultTableModel(Database.viewTableContents(), new String[]{
            "Student Name", "Education Plan", "College", "Career Path",
            "Ethnicity", "Regents", "NCAA", "1st Gen", "Gender", "Major", "GPA"}) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable studentTable = new JTable(studentModel);
    private JScrollPane tablePane = new JScrollPane(studentTable);
    //constructor
    public ViewPanel() {
        studentTable.getColumn("Student Name").setPreferredWidth(120);
        studentTable.getColumn("Education Plan").setPreferredWidth(130);
        studentTable.setAutoCreateRowSorter(true);
        tablePane.setPreferredSize(new Dimension(1100, 640));
        tablePane.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 1, true));
        add(tablePane);
    }
}
