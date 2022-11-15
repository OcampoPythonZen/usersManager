package edo.mex.gob.gui.menu;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class MenuGUI extends JFrame {

    JLabel firstNameLabel;
    JTextField firstNameText;

    JLabel firstSecondNameLabel;
    JTextField firstSecondNameText;

    JLabel lastNameLabel;
    JTextField lastNameText;

    JLabel secondLastNameLabel;
    JTextField secondLastnameText;

    JLabel manLabel;
    JRadioButton man;
    JLabel womanLabel;
    JRadioButton woman;

    JLabel emailLabel;
    JTextField emailText;

    JLabel streetNameLabel;
    JTextField streetNameText;

    JLabel interiorNumberLabel;
    JTextField interiorNumberText;

    JLabel exteriorNumberLabel;
    JTextField exteriorNumberText;

    JLabel suburbLabel;
    JTextField suburbText;

    JLabel zipCodeLabel;
    JTextField zipCodeText;

    JLabel municipalityLabel;
    JTextField municipalityText;

    JLabel stateLabel;
    JTextField stateText;

    JLabel countryLabel;
    JTextField countryText;

    JLabel phoneLabel;
    JTextField phoneText;

    JButton clearBtn;
    JButton cancelBtn;
    JButton submitBtn;

    public MenuGUI() {

        firstNameLabel = new JLabel("Primer Nombre");
        firstNameText = new JTextField(4);

        firstSecondNameLabel = new JLabel("Segundo Nombre");
        firstSecondNameText = new JTextField(4);

        lastNameLabel = new JLabel("Apellido Paterno");
        lastNameText = new JTextField(4);

        secondLastNameLabel = new JLabel("Apellido Materno");
        secondLastnameText = new JTextField(4);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        manLabel = new JLabel("Masculino");
        man = new JRadioButton();

        womanLabel =  new JLabel("Femenino");
        woman = new JRadioButton();

        emailLabel = new JLabel("Correo Electronico");
        emailText = new JTextField(4);

        streetNameLabel = new JLabel("Nombre de la Calle");
        streetNameText = new JTextField(4);

        interiorNumberLabel = new JLabel("Numero Interior");
        interiorNumberText = new JTextField(4);

        exteriorNumberLabel = new JLabel("Numero Exterior");
        exteriorNumberText = new JTextField(4);

        suburbLabel = new JLabel("Colonia");
        suburbText = new JTextField(4);

        zipCodeLabel = new JLabel("Codigo Postal");
        zipCodeText = new JTextField(4);

        municipalityLabel = new JLabel("Municipio");
        municipalityText = new JTextField(4);

        stateLabel = new JLabel("Estado");
        stateText = new JTextField(4);

        countryLabel = new JLabel("Ciudad");
        countryText = new JTextField(4);

        phoneLabel = new JLabel("Telefono/Celular");
        phoneText = new JTextField(4);

        clearBtn = new JButton("Limpiar Datos");
        cancelBtn = new JButton("Cancelar");
        submitBtn = new JButton("Enviar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 20, 20, 20);

        setLayout(new GridLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(firstNameLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(firstNameText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(firstSecondNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(firstSecondNameText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(datePicker, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(lastNameLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        add(lastNameText, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(secondLastNameLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        add(secondLastnameText, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        add(womanLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 3;
        add(woman, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        add(manLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        add(man, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(emailLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        add(emailText, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        add(streetNameLabel, constraints);

        constraints.gridx = 4;
        constraints.gridy = 2;
        add(streetNameText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(interiorNumberLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        add(interiorNumberText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        add(exteriorNumberLabel, constraints);

        constraints.gridx = 4;
        constraints.gridy = 1;
        add(exteriorNumberText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 3;
        add(suburbLabel, constraints);

        constraints.gridx = 4;
        constraints.gridy = 4;
        add(suburbText, constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        add(zipCodeLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 1;
        add(zipCodeText, constraints);

        constraints.gridx = 5;
        constraints.gridy = 2;
        add(municipalityLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 3;
        add(municipalityText, constraints);

        constraints.gridx = 5;
        constraints.gridy = 4;
        add(stateLabel, constraints);

        constraints.gridx = 6;
        constraints.gridy = 0;
        add(stateText, constraints);

        constraints.gridx = 6;
        constraints.gridy = 1;
        add(countryLabel, constraints);

        constraints.gridx = 6;
        constraints.gridy = 2;
        add(countryText, constraints);

        constraints.gridx = 6;
        constraints.gridy = 3;
        add(phoneLabel, constraints);

        constraints.gridx = 6;
        constraints.gridy = 4;
        add(phoneText, constraints);

        constraints.gridx = 7;
        constraints.gridy = 0;
        add(clearBtn, constraints);

        constraints.gridx = 7;
        constraints.gridy = 1;
        add(cancelBtn, constraints);

        constraints.gridx = 7;
        constraints.gridy = 2;
        add(submitBtn, constraints);


        setVisible(true);


    }
}
