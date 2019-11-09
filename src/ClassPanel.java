import com.alee.laf.panel.*;
import com.alee.managers.style.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClassPanel extends JPanel {
    //variable declarations
    private JPanel infoPane = new WebPanel(StyleId.of("shadow"));
    private GroupLayout infoLayout = new GroupLayout(infoPane);
    private JLabel classTitleLabel = new JLabel("Class Title:");
    private JTextField classTitle = new JTextField();
    private JLabel classCreditLabel = new JLabel("Credit Type:");
    private JComboBox classCredit = new JComboBox(Main.classTypes);
    private JLabel classPeriodLabel = new JLabel("Class Period(s):");
    private JComboBox classPeriod = new JComboBox(new String[]{"1A", "2A", "3A", "4A", "1B", "2B", "3B", "4B"});
    private JButton addClass = new JButton("Add Class");
    public ClassPanel() {
        addClass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    //add class column into database
                    Database.executeStatement("ALTER TABLE students ADD `" + classTitle.getText() + "_" + classPeriod.getSelectedItem() +
                            "` BOOLEAN");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        infoPane.setLayout(infoLayout);
        infoLayout.setAutoCreateGaps(true);
        infoLayout.setAutoCreateContainerGaps(true);
        infoLayout.setHorizontalGroup(infoLayout.createSequentialGroup()
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(classTitleLabel)
                        .addComponent(classCreditLabel)
                        .addComponent(classPeriodLabel))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(classTitle)
                        .addComponent(classCredit)
                        .addComponent(classPeriod)
                        .addComponent(addClass))
        );
        infoLayout.setVerticalGroup(infoLayout.createSequentialGroup()
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classTitleLabel)
                        .addComponent(classTitle))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classCreditLabel)
                        .addComponent(classCredit))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(classPeriodLabel)
                        .addComponent(classPeriod))
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(addClass))
        );
        add(infoPane);
    }
}
