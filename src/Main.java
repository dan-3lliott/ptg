import com.alee.laf.WebLookAndFeel;
import java.awt.EventQueue;

public class Main {
    public static final String[] classTypes = new String[]{"Language Arts", "Mathematics", "Science", "Social Studies",
            "U.S. Government/Citizenship", "Health Education", "Physical Education", "Fitness for Life", "Fine Arts",
            "Career and Technical Education", "Computer Technology", "General Financial Literacy", "Electives" }; //different class types with different requirements
    public static final String[] periods = new String[]{"1A", "2A", "3A", "4A", "1B", "2B", "3B", "4B"};
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install(PTGSkin.class); //installs the WebLookAndFeel library with the custom skin
                ptgWindow win = new ptgWindow();
                win.setVisible(true); //open main ptg window
            }
        });
    }
}
