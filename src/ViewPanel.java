import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.Dimension;
import java.awt.event.*;
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
    private WebTextField searchBar = new WebTextField();
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
        //double click mouse listener to open EditWindow
        studentTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ev) {
                if (ev.getClickCount() == 2) {
                    EditWindow win = new EditWindow((int)studentTable.getValueAt(studentTable.rowAtPoint(ev.getPoint()), 1), ViewPanel.this);
                    win.setVisible(true);
                }
            }
        });
        //set up layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //set up table
        studentTable.setRowHeight(30);
        studentTable.setRowSorter(rowSorter);
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        sizeColumns(); //size columns to their designated width
        tablePane.setFocusable(false);
        searchBar.setInputPrompt("Search..."); //note - this is a WebTextField exclusive functionality
        searchBar.setMaximumSize(new Dimension(600, 40));
        //add spacing and components
        add(tablePane);
        add(searchBar);
        add(Box.createRigidArea(new Dimension(0, 10)));
    }
    public void sizeColumns() {
        studentTable.getColumn("Student Name").setPreferredWidth(150);
        studentTable.getColumn("Student Number").setPreferredWidth(110);
        studentTable.getColumn("Education Plan").setPreferredWidth(150);
        studentTable.getColumn("College").setPreferredWidth(350);
        studentTable.getColumn("Career Path").setPreferredWidth(300);
        studentTable.getColumn("Ethnicity").setPreferredWidth(240);
        studentTable.getColumn("Gender").setPreferredWidth(80);
        studentTable.getColumn("Major").setPreferredWidth(250);
    }
    public void update() {
        studentModel.setDataVector(Database.viewTableContents(), studentTableHeader); //pulls updated table data from database
        sizeColumns();
    }
}
