import javax.swing.*;
import java.awt.*;

public class ptgWindow extends JFrame {
    private JPanel mainPanel = new JPanel();
    public ptgWindow() {
        setPreferredSize(new Dimension(1200, 700));
        setMinimumSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
        setTitle("ptg");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(mainPanel);
    }
}
