import javax.swing.*;
import java.awt.*;

public class EditWindow extends JFrame {
    //variable declaration
    private JPanel mainPane = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JPanel notesPanel = new JPanel();
    private JPanel classPanel = new JPanel();
    private Object[] studentData;
    private GroupLayout layout = new GroupLayout(infoPanel);
    private JLabel nameLabel = new JLabel("Name:");
    private JTextField name = new JTextField();
    private JLabel studentNumLabel = new JLabel("Student Number:");
    private JTextField studentNum = new JTextField();
    private JLabel eduLabel = new JLabel("Education Plan:");
    private JComboBox eduPlan = new JComboBox(new String[]{
            "High School Diploma", "Technical Training", "Associate Degree",
            "Bachelors Degree", "Advanced Degree", "Military", "Other"});
    private JLabel collegeLabel = new JLabel("College:");
    private JTextField college = new JTextField();
    private JLabel careerPathLabel = new JLabel("Career Path:");
    private JTextField careerPath = new JTextField();
    private JLabel ethnicityLabel = new JLabel("Ethnicity:");
    private JComboBox ethnicity = new JComboBox(new String[]{
            "Hispanic or Latino Origin", "American Indian or Alaska Native", "Asian", "Black or African American",
            "Native Hawaiian or Other Pacific Islander", "White", "Two or more races"});
    private JLabel regentsLabel = new JLabel("Regents:");
    private JCheckBox regents = new JCheckBox();
    private JLabel ncaaLabel = new JLabel("NCAA:");
    private JCheckBox ncaa = new JCheckBox();
    private JLabel firstGenLabel = new JLabel("First Gen:");
    private JCheckBox firstGen = new JCheckBox();
    private JLabel genderLabel = new JLabel("Gender:");
    private JComboBox gender = new JComboBox(new String[]{"Male", "Female", "Other"});
    private JLabel majorLabel = new JLabel("Major:");
    private JTextField major = new JTextField();
    private JLabel gpaLabel = new JLabel("GPA:");
    private JTextField gpa = new JTextField();
    private JButton addStudent = new JButton("Add Student");
    //constructor
    public EditWindow(int studentNo) {
        //set up window
        setPreferredSize(new Dimension(800, 500));
        setMinimumSize(new Dimension(800, 500));
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Edit Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPane);
        mainPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //get student data from database
        studentData = Database.studentData(studentNo);
        //will replicate addPanel in the future
    }
}
