import javax.swing.*;
import java.awt.*;

public class ptgWindow extends JFrame {
    private JTabbedPane mainPane = new JTabbedPane();
    private ViewPanel viewPanel = new ViewPanel();
    private AddPanel addPanel = new AddPanel(viewPanel);
    public ptgWindow() {
        //set up jframe
        setPreferredSize(new Dimension(1200, 700));
        setMinimumSize(new Dimension(1200, 700));
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("ptg");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPane);
        //add components
        mainPane.add(viewPanel, "View Students");
        mainPane.add(addPanel, "Add Student");
    }
}
