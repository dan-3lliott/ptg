import javax.swing.*;
import java.awt.*;

public class ptgWindow extends JFrame {
    private JTabbedPane mainPane = new JTabbedPane();
    private ViewPanel viewPanel = new ViewPanel();
    private AddPanel addPanel = new AddPanel(viewPanel);
    private ClassPanel classPanel = new ClassPanel(addPanel);
    public ptgWindow() {
        //set up jframe
        setPreferredSize(new Dimension(1600, 900));
        setMinimumSize(new Dimension(1600, 900));
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("ptg");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPane);
        //add components
        mainPane.add(viewPanel, "View Students");
        mainPane.add(addPanel, "Add Student");
        mainPane.add(classPanel, "Add Class");
    }
}
