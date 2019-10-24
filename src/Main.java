import com.alee.laf.*;
import java.awt.EventQueue;
import java.util.*;

public class Main {
    private static final String[] classTypes = new String[]{"Language Arts", "Mathematics", "Science", "Social Studies",
            "U.S. Government/Citizenship", "Health Education", "Physical Education", "Fitness for Life", "Fine Arts",
            "Career and Technical Education", "Computer Technology", "General Financial Literacy", "Electives" }; //different class types with different requirements
    private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install(com.alee.skin.dark.DarkSkin.class); //Installs the WebLookAndFeel library with the dark skin
                ptgWindow win = new ptgWindow();
                win.setVisible(true);
                String[] notes = new String[]{"Good student", "Better student", "Pretty dope student", "Best student"};
                students.add(new Student(notes, "eduPlan", "Caltech", "Engineering", "White", true, false, false, "Male", "Aerospace Engineering", 4.0));
            }
        });
    }
}
