import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.text.*;
import com.alee.managers.style.*;

public class ViewPanel extends JPanel {
    //variable declaration
    private String[] studentTableHeader = new String[]{ "Student Name", "Student Number", "Education Plan",
            "College", "Career Path", "Ethnicity", "Gender", "Major", "GPA"};
    private DefaultTableModel studentModel = new DefaultTableModel(Database.viewTableContents(), studentTableHeader) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable studentTable = new JTable(studentModel);
    private JScrollPane tablePane = new WebScrollPane(StyleId.of("scrollshadow"), studentTable);
    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(studentModel);
    private WebTextField searchBar = new WebTextField(40);
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
                    EditWindow win = new EditWindow((int)studentTable.getValueAt(studentTable.rowAtPoint(ev.getPoint()), 1), ViewPanel.this);
                    win.setVisible(true);
                }
            }
        });
        //set up layout
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        //set up table
        studentTable.setRowHeight(35);
        studentTable.setRowSorter(rowSorter);
        tablePane.setPreferredSize(new Dimension(1100, 600));
        tablePane.setFocusable(false);
        searchBar.setInputPrompt("Search...");
        add(tablePane);
        add(searchBar);
    }
    public void update() {
        studentModel.setDataVector(Database.viewTableContents(), studentTableHeader);
    }
}
