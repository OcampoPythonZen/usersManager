package edo.mex.gob.gui.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;
import javax.swing.BorderFactory;
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
    JLabel manLabel;
    JRadioButton man;
    JLabel womanLabel;
    JRadioButton woman;
    JLabel emailLabel;
    JTextField emailText;
    JLabel phoneLabel;
    JTextField phoneText;

    public PersonalDataPanel() {

        firstNameLabel = new JLabel("Primer Nombre:");
        firstNameText = new JTextField(8);

        firstSecondNameLabel = new JLabel("Segundo Nombre:");
        firstSecondNameText = new JTextField(8);

        lastNameLabel = new JLabel("Apellido Paterno:");
        lastNameText = new JTextField(8);

        secondLastNameLabel = new JLabel("Apellido Materno:");
        secondLastnameText = new JTextField(8);

        birthDateLabel = new JLabel("Fecha de Nacimiento:");

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        manLabel = new JLabel("H");
        man = new JRadioButton();

        womanLabel = new JLabel("M");
        woman = new JRadioButton();

        emailLabel = new JLabel("Correo Electronico:");
        emailText = new JTextField(8);

        phoneLabel = new JLabel("Telefono / Celular:");
        phoneText = new JTextField(8);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 20, 20, 20);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Datos del Usuario"));

        setLayout(new GridBagLayout());

        add(firstNameLabel, constraints);
        add(firstNameText, constraints);

        add(firstSecondNameLabel, constraints);
        add(firstSecondNameText, constraints);

        add(lastNameLabel, constraints);
        add(lastNameText, constraints);

        add(secondLastNameLabel, constraints);
        add(secondLastnameText, constraints);

        add(birthDateLabel, constraints);
        add(datePicker, constraints);

        add(manLabel, constraints);
        add(man, constraints);

        add(womanLabel, constraints);
        add(woman, constraints);

        add(emailLabel, constraints);
        add(emailText, constraints);

        add(phoneLabel, constraints);
        add(phoneText, constraints);

    }

}
