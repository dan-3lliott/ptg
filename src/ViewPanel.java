import javax.swing.*;

public class ViewPanel extends JPanel {
    //variable declaration
    private JTable studentTable = new JTable(10, 10);
    //constructor
    public ViewPanel() {
        add(new JScrollPane(studentTable));
    }
}
