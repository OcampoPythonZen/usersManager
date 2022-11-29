package edo.mex.gob.gui.course;

import edo.mex.gob.gui.user.DateLabelFormatter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CreateCoursePanel extends JPanel {

    JLabel courseNameLabel;
    JTextField courseNameField;

    JLabel professorCourseLabel;
    JTextField professorCourseField;

    JLabel descriptionLabel;
    JTextArea descriptionArea;
    JScrollPane scroll;

    JLabel startDateLabel;
    JLabel finishedDateLabel;

    JButton clearBtn;
    JButton cancelBtn;
    JButton submitBtn;


    public CreateCoursePanel() {

        courseNameLabel = new JLabel("Nombre del curso:");
        courseNameField = new JTextField(16);

        professorCourseLabel = new JLabel("Nombre del profesor:");
        professorCourseField = new JTextField(16);

        descriptionLabel = new JLabel("Descripcion del Curso:");
        descriptionArea = new JTextArea("Pega la info del curso:\n", 8, 35);
        scroll = new JScrollPane(descriptionArea);

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

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(scroll, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(cancelBtn, constraints);

        constraints.gridx = 2;
        constraints.gridy = 7;
        add(clearBtn, constraints);

        constraints.gridx = 4;
        constraints.gridy = 7;
        add(submitBtn, constraints);

    }
}
