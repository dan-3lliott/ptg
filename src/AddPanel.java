import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPanel extends JPanel {
    //variable declarations
    private JPanel inputPane = new JPanel();
    private GroupLayout layout = new GroupLayout(inputPane);
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
    public AddPanel() {
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Main.students.add(new Student(null, eduPlan.getSelectedItem().toString(), college.getText(),
                            careerPath.getText(), ethnicity.getSelectedItem().toString(), regents.isSelected(), ncaa.isSelected(),
                            firstGen.isSelected(), gender.getSelectedItem().toString(), major.getText(), Double.parseDouble(gpa.getText())));
                    Database db = new Database();
                    db.sqlStatement("INSERT INTO `students` (`notes0`, `notes1`, `notes2`, `notes3`, `eduPlan`, " +
                            "`college`, `careerPath`, `ethnicity`, `regents`, `ncaa`, `firstGen`, `gender`, `major`, " +
                            "`gpa`) VALUES ('9th Grade Notes', '10th Grade Notes', '11th Grade Notes', '12th Grade Notes', " +
                            "'" + eduPlan.getSelectedItem() + "', '" + college.getText() + "', '" + careerPath.getText() + "', '" +
                            ethnicity.getSelectedItem() + "', '" + regents.isSelected() + "', '0', '0', '0', 'sdlfkj', 'sdlfkj', '3.0')");
                    JOptionPane.showMessageDialog(null, "Student successfully added.");
                    //reset all fields
                    eduPlan.setSelectedIndex(0);
                    college.setText(null);
                    careerPath.setText(null);
                    ethnicity.setSelectedIndex(0);
                    regents.setSelected(false);
                    ncaa.setSelected(false);
                    firstGen.setSelected(false);
                    gender.setSelectedIndex(0);
                    major.setText(null);
                    gpa.setText(null);
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please ensure that all fields are correct before proceeding.");
                }
            }
        });
        //set up content pane
        inputPane.setPreferredSize(new Dimension(1100, 640));
        inputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        inputPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //add components to layout and pane
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(eduLabel)
                        .addComponent(collegeLabel)
                        .addComponent(careerPathLabel)
                        .addComponent(ethnicityLabel)
                        .addComponent(regentsLabel)
                        .addComponent(ncaaLabel)
                        .addComponent(firstGenLabel)
                        .addComponent(genderLabel)
                        .addComponent(majorLabel)
                        .addComponent(gpaLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(eduPlan)
                        .addComponent(college)
                        .addComponent(careerPath)
                        .addComponent(ethnicity)
                        .addComponent(regents)
                        .addComponent(ncaa)
                        .addComponent(firstGen)
                        .addComponent(gender)
                        .addComponent(major)
                        .addComponent(gpa)
                        .addComponent(addStudent))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(eduLabel)
                        .addComponent(eduPlan))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(collegeLabel)
                        .addComponent(college))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(careerPathLabel)
                        .addComponent(careerPath))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(ethnicityLabel)
                        .addComponent(ethnicity))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(regentsLabel)
                        .addComponent(regents))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(ncaaLabel)
                        .addComponent(ncaa))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(firstGenLabel)
                        .addComponent(firstGen))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(genderLabel)
                        .addComponent(gender))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(majorLabel)
                        .addComponent(major))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(gpaLabel)
                        .addComponent(gpa))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(addStudent))
        );
        add(inputPane);
    }
}
