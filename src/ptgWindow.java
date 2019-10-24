import javax.swing.*;
import java.awt.*;
import com.alee.laf.*;

public class ptgWindow extends JFrame {
    private JTabbedPane mainPane = new JTabbedPane();
    private ViewPanel viewPanel = new ViewPanel();
    private JPanel addPanel = new JPanel();
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
    }
}
