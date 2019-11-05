import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
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
    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(studentModel);
    private JLabel searchLabel = new JLabel("Search:");
    private JTextField searchBar = new JTextField(20);
    //constructor
    public ViewPanel() {
        //search functionality
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (searchBar.getText().trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchBar.getText()));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (searchBar.getText().trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchBar.getText()));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (searchBar.getText().trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchBar.getText()));
                }
            }
        });
        //set up table
        studentTable.getColumn("Student Name").setPreferredWidth(100);
        studentTable.getColumn("Education Plan").setPreferredWidth(110);
        studentTable.getColumn("College").setPreferredWidth(80);
        studentTable.getColumn("Regents").setPreferredWidth(40);
        studentTable.getColumn("NCAA").setPreferredWidth(40);
        studentTable.getColumn("1st Gen").setPreferredWidth(40);
        studentTable.getColumn("Major").setPreferredWidth(100);
        studentTable.getColumn("Gender").setPreferredWidth(30);
        studentTable.getColumn("GPA").setPreferredWidth(12);
        //ethnicity and career path are 'flex' and are not specified
        studentTable.setRowHeight(30);
        studentTable.setRowSorter(rowSorter);
        tablePane.setPreferredSize(new Dimension(1150, 600));
        tablePane.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 1, true));
        add(tablePane);
        add(searchLabel);
        add(searchBar);
    }
}
