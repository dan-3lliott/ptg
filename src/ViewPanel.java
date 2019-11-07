import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.Dimension;
import java.awt.event.*;
import com.alee.laf.text.*;

public class ViewPanel extends JPanel {
    //variable declaration
    private String[] studentTableHeader = new String[]{ "Student Name", "Student Number", "Education Plan",
            "College", "Career Path", "Ethnicity", "Regents", "NCAA", "1st Gen", "Gender", "Major", "GPA"};
    private DefaultTableModel studentModel = new DefaultTableModel(Database.viewTableContents(), studentTableHeader) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable studentTable = new JTable(studentModel);
    private JScrollPane tablePane = new JScrollPane(studentTable);
    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(studentModel);
    private WebTextField searchBar = new WebTextField(20);
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
        studentTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ev) {
                if (ev.getClickCount() == 2) {
                    EditWindow win = new EditWindow((int)studentTable.getValueAt(studentTable.rowAtPoint(ev.getPoint()), 1));
                    win.setVisible(true);
                }
            }
        });
        //set up table
        studentTable.getColumn("GPA").setPreferredWidth(12);
        studentTable.setRowHeight(30);
        studentTable.setRowSorter(rowSorter);
        tablePane.setPreferredSize(new Dimension(1150, 620));
        tablePane.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 1, true));
        searchBar.setInputPrompt("Search...");
        add(tablePane);
        add(searchBar);
    }
    public void update() {
        studentModel.setDataVector(Database.viewTableContents(), studentTableHeader);
    }
}
