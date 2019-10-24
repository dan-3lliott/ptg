import com.alee.laf.*;
import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install(); //Installs the WebLookAndFeel library
                ptgWindow win = new ptgWindow();
                win.setVisible(true);
            }
        });
    }
}
