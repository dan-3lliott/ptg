import javax.swing.*;
import java.awt.*;

public class EditWindow extends JFrame {
    //variable declaration
    private JPanel mainPane = new JPanel();
    //constructor
    public EditWindow(int studentNum) {
        setPreferredSize(new Dimension(800, 500));
        setMinimumSize(new Dimension(800, 500));
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Edit Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPane);
        System.out.println(studentNum);
    }
}
