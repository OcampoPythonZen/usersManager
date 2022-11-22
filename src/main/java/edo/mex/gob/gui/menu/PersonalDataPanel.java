package edo.mex.gob.gui.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class PersonalDataPanel extends JPanel {

    JLabel firstNameLabel;
    JTextField firstNameText;
    JLabel firstSecondNameLabel;
    JTextField firstSecondNameText;
    JLabel lastNameLabel;
    JTextField lastNameText;
    JLabel secondLastNameLabel;
    JTextField secondLastnameText;
    JLabel birthDateLabel;
    JLabel sexLabel;
    JRadioButton man;
    JRadioButton woman;
    ButtonGroup genderGroup;
    JLabel emailLabel;
    JTextField emailText;
    JLabel phoneLabel;
    JTextField phoneText;

    public PersonalDataPanel() {

        firstNameLabel = new JLabel("Primer Nombre:");
        firstNameText = new JTextField(16);

        firstSecondNameLabel = new JLabel("Segundo Nombre:");
        firstSecondNameText = new JTextField(16);

        lastNameLabel = new JLabel("Apellido Paterno:");
        lastNameText = new JTextField(16);

        secondLastNameLabel = new JLabel("Apellido Materno:");
        secondLastnameText = new JTextField(16);

        birthDateLabel = new JLabel("Fecha de Nacimiento:");
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        sexLabel = new JLabel("Sexo:");
        genderGroup = new ButtonGroup();
        man = new JRadioButton("Hombre", false);
        woman = new JRadioButton("Mujer", false);
        genderGroup.add(man);
        genderGroup.add(woman);

        emailLabel = new JLabel("Correo Electronico:");
        emailText = new JTextField(32);

        phoneLabel = new JLabel("Telefono / Celular:");
        phoneText = new JTextField(32);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Datos del Usuario"));

        setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(firstNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(firstNameText, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add(firstSecondNameLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(firstSecondNameText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(lastNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(lastNameText, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        add(secondLastNameLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        add(secondLastnameText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(birthDateLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        add(datePicker, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        add(sexLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        add(man, constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;
        add(woman, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(emailLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        add(emailText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(phoneLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        add(phoneText, constraints);

    }

}
