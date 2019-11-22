import com.alee.laf.panel.WebPanel;
import com.alee.managers.style.StyleId;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
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
    private JComboBox[] classes = new JComboBox[8]; //index 0 -> 1a, 2 -> 2a, ... 7 -> 4b
    private JLabel[] classLabels = new JLabel[8];
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
                    //make class columns reflect scheduling
                    String statement = "UPDATE students SET ";
                    for (int i = 0; i < classLabels.length; i++) {
                        if (classes[i].getSelectedItem() != null) {
                            statement += "`" + classes[i].getSelectedItem() + "_" + classLabels[i].getText().substring(0, classLabels[i].getText().indexOf(":")) + "` = '1', ";
                        }
                    }
                    statement = statement.substring(0, statement.length() - 2) + " WHERE studentNum = '" + studentNum.getText() + "'"; //finalize statement and remove last comma
                    Database.executeStatement(statement);
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
                    for (JComboBox cb : classes) {
                        cb.setSelectedIndex(-1);
                    }
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please ensure that all fields are correct before proceeding.");
                }
            }
        });
        //set up content pane
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //set up each individual panel
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
        //set up class combo boxes
        List<Object[]> dbClasses = Database.classes();
        for (int i = 0; i < dbClasses.size(); i++) {
            classes[i] = new JComboBox<>(dbClasses.get(i));
            classes[i].setSelectedIndex(-1);
        }
        //set up class labels
        for (int i = 0; i < classes.length; i++) {
            classLabels[i] = new JLabel(Main.periods[i] + ":");
        }
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
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                        .addComponent(notes0label)
                        .addComponent(notes0pane)
                        .addComponent(notes2label)
                        .addComponent(notes2pane))
                .addGroup(noteLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
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
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, true)
                        .addComponent(classLabels[0])
                        .addComponent(classLabels[1])
                        .addComponent(classLabels[2])
                        .addComponent(classLabels[3]))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                        .addComponent(classes[0])
                        .addComponent(classes[1])
                        .addComponent(classes[2])
                        .addComponent(classes[3]))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, true)
                        .addComponent(classLabels[4])
                        .addComponent(classLabels[5])
                        .addComponent(classLabels[6])
                        .addComponent(classLabels[7]))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                        .addComponent(classes[4])
                        .addComponent(classes[5])
                        .addComponent(classes[6])
                        .addComponent(classes[7]))
        );
        classLayout.setVerticalGroup(classLayout.createSequentialGroup()
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classLabels[0])
                        .addComponent(classes[0])
                        .addComponent(classLabels[4])
                        .addComponent(classes[4]))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classLabels[1])
                        .addComponent(classes[1])
                        .addComponent(classLabels[5])
                        .addComponent(classes[5]))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classLabels[2])
                        .addComponent(classes[2])
                        .addComponent(classLabels[6])
                        .addComponent(classes[6]))
                .addGroup(classLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classLabels[3])
                        .addComponent(classes[3])
                        .addComponent(classLabels[7])
                        .addComponent(classes[7]))
        );
        //set up panel sizing

        //add spacing and content panels
        add(Box.createHorizontalGlue());
        add(infoPane);
        add(notePane);
        add(classPane);
        add(Box.createHorizontalGlue());
    }
    public void update() {
        List<Object[]> dbClasses = Database.classes();
        for (int i = 0; i < dbClasses.size(); i++) {
            classes[i].setModel(new DefaultComboBoxModel<>(dbClasses.get(i)));
            classes[i].setSelectedIndex(-1);
        }
    }
}
