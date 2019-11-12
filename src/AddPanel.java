import com.alee.laf.panel.*;
import com.alee.managers.style.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class AddPanel extends JPanel {
    //variable declarations
    private JPanel infoPane = new WebPanel(StyleId.of("shadow"));
    private JPanel notePane = new WebPanel(StyleId.of("shadow"));
    private JPanel classPane = new WebPanel(StyleId.of("shadow"));
    private GroupLayout infoLayout = new GroupLayout(infoPane);
    private GroupLayout noteLayout = new GroupLayout(notePane);
    private GroupLayout classLayout = new GroupLayout(classPane);
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
    private JLabel notes0label = new JLabel("9th Grade Notes:");
    private JTextArea notes0 = new JTextArea(6, 20);
    private JLabel notes1label = new JLabel("10th Grade Notes:");
    private JTextArea notes1 = new JTextArea(6, 20);
    private JLabel notes2label = new JLabel("11th Grade Notes:");
    private JTextArea notes2 = new JTextArea(6, 20);
    private JLabel notes3label = new JLabel("12th Grade Notes:");
    private JTextArea notes3 = new JTextArea(6, 20);
    private JScrollPane notes0pane = new JScrollPane(notes0);
    private JScrollPane notes1pane = new JScrollPane(notes1);
    private JScrollPane notes2pane = new JScrollPane(notes2);
    private JScrollPane notes3pane = new JScrollPane(notes3);
    private Object[] classes = Database.classes();
    private JLabel a1label = new JLabel("A1:");
    private JComboBox a1 = new JComboBox(classes);
    private JLabel a2label = new JLabel("A2:");
    private JComboBox a2 = new JComboBox(classes);
    private JLabel a3label = new JLabel("A3:");
    private JComboBox a3 = new JComboBox(classes);
    private JLabel a4label = new JLabel("A4:");
    private JComboBox a4 = new JComboBox(classes);
    private JLabel b1label = new JLabel("B1:");
    private JComboBox b1 = new JComboBox(classes);
    private JLabel b2label = new JLabel("B2:");
    private JComboBox b2 = new JComboBox(classes);
    private JLabel b3label = new JLabel("B3:");
    private JComboBox b3 = new JComboBox(classes);
    private JLabel b4label = new JLabel("B4:");
    private JComboBox b4 = new JComboBox(classes);
    //constructor
    public AddPanel(ViewPanel viewPanelReference) {
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    //add student into database
                    Database.executeStatement("INSERT INTO students (notes0, notes1, notes2, notes3, name, eduPlan, " +
                            "college, careerPath, ethnicity, regents, ncaa, firstGen, gender, major, " +
                            "gpa, studentNum) VALUES ('" + notes0.getText() + "', '" + notes1.getText() + "', '" + notes2.getText() +
                            "', '" + notes3.getText() + "', '" + name.getText() + "', '" + eduPlan.getSelectedItem() + "', '" +
                            college.getText() + "', '" + careerPath.getText() + "', '" + ethnicity.getSelectedItem() + "', '" +
                            (regents.isSelected() ? 1 : 0) + "', '" + (ncaa.isSelected() ? 1 : 0) + "', '" + (firstGen.isSelected() ? 1 : 0) +
                            "', '" + gender.getSelectedItem() + "', '" + major.getText() + "', '" + gpa.getText() + "', '" + studentNum.getText() + "')");
                    //add student into table
                    viewPanelReference.update();
                    JOptionPane.showMessageDialog(null, "Student successfully added.");
                    //reset all fields
                    name.setText(null);
                    studentNum.setText(null);
                    eduPlan.setSelectedIndex(-1);
                    college.setText(null);
                    careerPath.setText(null);
                    ethnicity.setSelectedIndex(-1);
                    regents.setSelected(false);
                    ncaa.setSelected(false);
                    firstGen.setSelected(false);
                    gender.setSelectedIndex(-1);
                    major.setText(null);
                    gpa.setText(null);
                    notes0.setText(null);
                    notes1.setText(null);
                    notes2.setText(null);
                    notes3.setText(null);
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please ensure that all fields are correct before proceeding.");
                }
            }
        });
        //set up content pane
        infoPane.setLayout(infoLayout);
        notePane.setLayout(noteLayout);
        classPane.setLayout(classLayout);
        infoLayout.setAutoCreateGaps(true);
        infoLayout.setAutoCreateContainerGaps(true);
        noteLayout.setAutoCreateGaps(true);
        noteLayout.setAutoCreateContainerGaps(true);
        classLayout.setAutoCreateGaps(true);
        classLayout.setAutoCreateContainerGaps(true);
        //set up components
        eduPlan.setSelectedIndex(-1);
        ethnicity.setSelectedIndex(-1);
        gender.setSelectedIndex(-1);
        notes0.setLineWrap(true);
        notes0.setWrapStyleWord(true);
        notes1.setLineWrap(true);
        notes1.setWrapStyleWord(true);
        notes2.setLineWrap(true);
        notes2.setWrapStyleWord(true);
        notes3.setLineWrap(true);
        notes3.setWrapStyleWord(true);
        a1.setSelectedIndex(-1);
        a2.setSelectedIndex(-1);
        a3.setSelectedIndex(-1);
        a4.setSelectedIndex(-1);
        b1.setSelectedIndex(-1);
        b2.setSelectedIndex(-1);
        b3.setSelectedIndex(-1);
        b4.setSelectedIndex(-1);
        //add components to infoLayout and infoPane
        infoLayout.setHorizontalGroup(infoLayout.createSequentialGroup()
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nameLabel)
                        .addComponent(studentNumLabel)
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
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(name)
                        .addComponent(studentNum)
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
        infoLayout.setVerticalGroup(infoLayout.createSequentialGroup()
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(nameLabel)
                        .addComponent(name))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(studentNumLabel)
                        .addComponent(studentNum))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(eduLabel)
                        .addComponent(eduPlan))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(collegeLabel)
                        .addComponent(college))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(careerPathLabel)
                        .addComponent(careerPath))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(ethnicityLabel)
                        .addComponent(ethnicity))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(regentsLabel)
                        .addComponent(regents))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(ncaaLabel)
                        .addComponent(ncaa))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(firstGenLabel)
                        .addComponent(firstGen))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(genderLabel)
                        .addComponent(gender))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(majorLabel)
                        .addComponent(major))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(gpaLabel)
                        .addComponent(gpa))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(addStudent))
        );
        //add components to noteLayout and notePane
        noteLayout.setHorizontalGroup(noteLayout.createSequentialGroup()
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(notes0label)
                        .addComponent(notes0pane)
                        .addComponent(notes2label)
                        .addComponent(notes2pane))
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(notes1label)
                        .addComponent(notes1pane)
                        .addComponent(notes3label)
                        .addComponent(notes3pane))
        );
        noteLayout.setVerticalGroup(noteLayout.createSequentialGroup()
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(notes0label)
                        .addComponent(notes1label))
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(notes0pane)
                        .addComponent(notes1pane))
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(notes2label)
                        .addComponent(notes3label))
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(notes2pane)
                        .addComponent(notes3pane))
        );
        //add components to classLayout and classPane
        classLayout.setHorizontalGroup(classLayout.createSequentialGroup()
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(a1label)
                        .addComponent(a2label)
                        .addComponent(a3label)
                        .addComponent(a4label))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(a1)
                        .addComponent(a2)
                        .addComponent(a3)
                        .addComponent(a4))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(b1label)
                        .addComponent(b2label)
                        .addComponent(b3label)
                        .addComponent(b4label))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(b1)
                        .addComponent(b2)
                        .addComponent(b3)
                        .addComponent(b4))
        );
        classLayout.setVerticalGroup(classLayout.createSequentialGroup()
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(a1label)
                        .addComponent(a1)
                        .addComponent(b1label)
                        .addComponent(b1))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(a2label)
                        .addComponent(a2)
                        .addComponent(b2label)
                        .addComponent(b2))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(a3label)
                        .addComponent(a3)
                        .addComponent(b3label)
                        .addComponent(b3))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(a4label)
                        .addComponent(a4)
                        .addComponent(b4label)
                        .addComponent(b4))
        );
        //add panels
        add(infoPane);
        add(notePane);
        add(classPane);
    }
}
