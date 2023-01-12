package edo.mex.gob.gui.course;

import static edo.mex.gob.gui.Util.clearAllFields;
import edo.mex.gob.gui.menu.MenuGUI;
import edo.mex.gob.gui.user.DateLabelFormatter;
import edo.mex.gob.repository.Connector;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CreateCoursePanel extends JPanel {

    JLabel courseNameLabel;
    JTextField courseNameField;

    JLabel professorCourseLabel;
    JTextField professorCourseField;

    JTextArea descriptionArea;
    JScrollPane scroll;

    JLabel startDateLabel;
    JLabel finishedDateLabel;

    JLabel startedHourLabel;
    JComboBox<String> startedHourBox;

    JLabel finishedHourLabel;
    JComboBox<String> finishedHourBox;

    JLabel coursePlaceLabel;
    JTextField coursePlaceField;

    JButton clearBtn;
    JButton cancelBtn;
    JButton submitBtn;


    public CreateCoursePanel() {

        courseNameLabel = new JLabel("Nombre del curso:");
        courseNameField = new JTextField(16);

        professorCourseLabel = new JLabel("Nombre del profesor:");
        professorCourseField = new JTextField(16);

        startDateLabel = new JLabel("Fecha de inicio del curso:");
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl dateStarterPicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        finishedDateLabel = new JLabel("Fecha de terminacion del curso:");
        UtilDateModel model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl dateFinishedPicker = new JDatePickerImpl(datePanel1, new DateLabelFormatter());

        descriptionArea = new JTextArea("Info del curso:\n", 8, 35);
        scroll = new JScrollPane(descriptionArea);

        startedHourLabel = new JLabel("Hora de inicio del curso:");
        startedHourBox = new JComboBox<String>();
        startedHourBox.addItem("09:00 Hrs");
        startedHourBox.addItem("10:00 Hrs");
        startedHourBox.addItem("11:00 Hrs");
        startedHourBox.addItem("12:00 Hrs");
        startedHourBox.addItem("13:00 Hrs");

        finishedHourLabel = new JLabel("Hora de termino del curso:");
        finishedHourBox = new JComboBox<String>();
        finishedHourBox.addItem("12:00 Hrs");
        finishedHourBox.addItem("13:00 Hrs");
        finishedHourBox.addItem("14:00 Hrs");
        finishedHourBox.addItem("15:00 Hrs");
        finishedHourBox.addItem("16:00 Hrs");

        coursePlaceLabel = new JLabel("Lugar del curso:");
        coursePlaceField = new JTextField(16);


        clearBtn = new JButton("Limpiar");
        cancelBtn = new JButton("Salir");
        submitBtn = new JButton("Guardar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(courseNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(courseNameField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add(professorCourseLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(professorCourseField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(startDateLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(dateStarterPicker, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        add(finishedDateLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        add(dateFinishedPicker, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(startedHourLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(startedHourBox, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        add(finishedHourLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 4;
        add(finishedHourBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        add(coursePlaceLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        add(coursePlaceField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;
        add(scroll, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        add(cancelBtn, constraints);

        constraints.gridx = 2;
        constraints.gridy = 10;
        add(clearBtn, constraints);

        constraints.gridx = 4;
        constraints.gridy = 10;
        add(submitBtn, constraints);

        cancelBtn.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
            new MenuGUI().setVisible(true);
        });

        clearBtn.addActionListener(e -> {
            List<JTextField> allJTextField = (List<JTextField>) List.of(
                    courseNameField,
                    professorCourseField,
                    coursePlaceField,
                    dateStarterPicker.getJFormattedTextField(),
                    dateFinishedPicker.getJFormattedTextField()
            );
            descriptionArea.setText("");
            clearAllFields(allJTextField);
            courseNameField.requestFocus();
        });

        submitBtn.addActionListener(e -> {
            String courseName = courseNameField.getText();
            String professor = professorCourseField.getText();
            String initialDate = dateStarterPicker.getJFormattedTextField().getText();
            String finalDate = dateFinishedPicker.getJFormattedTextField().getText();
            String initialHour = String.valueOf(startedHourBox.getSelectedItem());
            String finalHour = String.valueOf(finishedHourBox.getSelectedItem());
            String place = coursePlaceField.getText();
            String info = descriptionArea.getText();

            String query = String.format(
                    "INSERT INTO course(" +
                            "course_name, professor, initial_date, final_date, initial_hour, final_hour, course_place, course_status, course_info)" +
                            "VALUES('%s', '%s', '%s', '%s', '%s', '%s','%s',  '%b', '%s');",
                    courseName,
                    professor,
                    initialDate,
                    finalDate,
                    initialHour,
                    finalHour,
                    place,
                    false,
                    info
            );

            try {
                new Connector().insertIntoTable(query);
                JOptionPane.showMessageDialog(
                        this.getTopLevelAncestor(),
                        "Curso almacenado en base de datos!",
                        "ALTA DE CURSO",
                        JOptionPane.INFORMATION_MESSAGE
                );
                List<JTextField> allJTextField = (List<JTextField>) List.of(
                        courseNameField,
                        professorCourseField,
                        coursePlaceField,
                        dateStarterPicker.getJFormattedTextField(),
                        dateFinishedPicker.getJFormattedTextField()
                );
                descriptionArea.setText("");
                clearAllFields(allJTextField);
                courseNameField.requestFocus();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
