import com.alee.laf.panel.WebPanel;
import com.alee.managers.style.StyleId;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

public class EditWindow extends JFrame {
    //variable declarations
    private Object[] studentData;
    private JPanel mainPane = new JPanel();
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
    private JComboBox<String> eduPlan = new JComboBox<>(new String[]{
            "High School Diploma", "Technical Training", "Associate Degree",
            "Bachelors Degree", "Advanced Degree", "Military", "Other"});
    private JLabel collegeLabel = new JLabel("College:");
    private JTextField college = new JTextField();
    private JLabel careerPathLabel = new JLabel("Career Path:");
    private JTextField careerPath = new JTextField();
    private JLabel ethnicityLabel = new JLabel("Ethnicity:");
    private JComboBox<String> ethnicity = new JComboBox<>(new String[]{
            "Hispanic or Latino Origin", "American Indian or Alaska Native", "Asian", "Black or African American",
            "Native Hawaiian or Other Pacific Islander", "White", "Two or more races"});
    private JLabel regentsLabel = new JLabel("Regents:");
    private JCheckBox regents = new JCheckBox();
    private JLabel ncaaLabel = new JLabel("NCAA:");
    private JCheckBox ncaa = new JCheckBox();
    private JLabel firstGenLabel = new JLabel("First Gen:");
    private JCheckBox firstGen = new JCheckBox();
    private JLabel genderLabel = new JLabel("Gender:");
    private JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female", "Other"});
    private JLabel majorLabel = new JLabel("Major:");
    private JTextField major = new JTextField();
    private JLabel gpaLabel = new JLabel("GPA:");
    private JTextField gpa = new JTextField();
    private JButton editStudent = new JButton("Confirm Changes");
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
    //constructor
    public EditWindow(int studentNo, ViewPanel viewPanelReference) {
        //get student data from database
        studentData = Database.studentData(studentNo);
        //action listener for the button to confirm changes
        editStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    //update student info in database
                    Database.executeStatement("UPDATE students SET name = '" + name.getText() + "', studentNum = " + studentNum.getText() + ", eduPlan = '" +
                            eduPlan.getSelectedItem() + "', college = '" + college.getText() + "', careerPath = '" + careerPath.getText() + "', ethnicity = '" +
                            ethnicity.getSelectedItem() + "', regents = " + (regents.isSelected() ? 1 : 0) + ", ncaa = " + (ncaa.isSelected() ? 1 : 0) +
                            ", firstGen = " + (firstGen.isSelected() ? 1 : 0) + ", gender = '" + gender.getSelectedItem() + "', major = '" +
                            major.getText() + "', gpa = " + gpa.getText() + " WHERE id = " + studentData[16]);
                    //update student info in table
                    viewPanelReference.update();
                    JOptionPane.showMessageDialog(null, "Student successfully edited.");
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
                EditWindow.super.dispose();
            }
        });
        //set up content pane and window
        setPreferredSize(new Dimension(1100, 485));
        setMinimumSize(new Dimension(1100, 485));
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Edit Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPane);
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
                        .addComponent(editStudent))
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
                        .addComponent(editStudent))
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

        //update fields with student information
        name.setText(studentData[0].toString());
        studentNum.setText(studentData[1].toString());
        eduPlan.setSelectedItem(studentData[2].toString());
        college.setText(studentData[3].toString());
        careerPath.setText(studentData[4].toString());
        ethnicity.setSelectedItem(studentData[5].toString());
        regents.setSelected((Boolean)studentData[6]);
        ncaa.setSelected((Boolean)studentData[7]);
        firstGen.setSelected((Boolean)studentData[8]);
        gender.setSelectedItem(studentData[9].toString());
        major.setText(studentData[10].toString());
        gpa.setText(studentData[11].toString());
        notes0.setText(studentData[12].toString());
        notes1.setText(studentData[13].toString());
        notes2.setText(studentData[14].toString());
        notes3.setText(studentData[15].toString());
        //add panels and spacing
        mainPane.add(infoPane);
        mainPane.add(notePane);
        //mainPane.add(classPane);
    }
}

