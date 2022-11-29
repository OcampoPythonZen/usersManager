package edo.mex.gob.gui.user;

import edo.mex.gob.repository.Connector;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CreateUserPanel extends JPanel {

    //Personal  Data
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
    JLabel womanLabel;
    JRadioButton woman;
    ButtonGroup genderGroup;
    JLabel emailLabel;
    JTextField emailText;
    JLabel phoneLabel;
    JTextField phoneText;

    //Address Date
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

    //Buttons
    JButton clearBtn;
    JButton cancelBtn;
    JButton submitBtn;

    public CreateUserPanel() {

        //Personal Date
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

        //Address Data
        streetNameLabel = new JLabel("Nombre de la Calle:");
        streetNameText = new JTextField(16);

        interiorNumberLabel = new JLabel("Numero Interior:");
        interiorNumberText = new JTextField(8);

        exteriorNumberLabel = new JLabel("Numero Exterior:");
        exteriorNumberText = new JTextField(8);

        suburbLabel = new JLabel("Colonia:");
        suburbText = new JTextField(16);

        zipCodeLabel = new JLabel("Codigo Postal:");
        zipCodeText = new JTextField(4);

        municipalityLabel = new JLabel("Municipio:");
        municipalityText = new JTextField(16);

        stateLabel = new JLabel("Estado:");
        stateText = new JTextField(16);

        countryLabel = new JLabel("Ciudad:");
        countryText = new JTextField(16);

        //Buttons
        clearBtn = new JButton("Limpiar");
        cancelBtn = new JButton("Salir");
        submitBtn = new JButton("Guardar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        setLayout(new GridBagLayout());

        //Personal Data Elements
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

        //Address Data Elements
        constraints.gridx = 0;
        constraints.gridy = 10;
        add(streetNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 10;
        add(streetNameText, constraints);

        constraints.gridx = 2;
        constraints.gridy = 10;
        add(interiorNumberLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 10;
        add(interiorNumberText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 10;
        add(exteriorNumberLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 10;
        add(exteriorNumberText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 12;
        add(suburbLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 12;
        add(suburbText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 12;
        add(zipCodeLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 12;
        add(zipCodeText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 14;
        add(municipalityLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 14;
        add(municipalityText, constraints);

        constraints.gridx = 2;
        constraints.gridy = 14;
        add(stateLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 14;
        add(stateText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 14;
        add(countryLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 14;
        add(countryText, constraints);

        //Buttons
        constraints.gridx = 0;
        constraints.gridy = 17;
        add(clearBtn, constraints);

        constraints.gridx = 2;
        constraints.gridy = 17;
        add(cancelBtn, constraints);

        constraints.gridx = 4;
        constraints.gridy = 17;
        add(submitBtn, constraints);

        cancelBtn.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        });

        clearBtn.addActionListener(e -> {
            List<JTextField> allJTextField = List.of(
                    firstNameText,
                    firstSecondNameText,
                    lastNameText,
                    secondLastnameText,
                    datePicker.getJFormattedTextField(),
                    emailText,
                    phoneText,

                    streetNameText,
                    interiorNumberText,
                    exteriorNumberText,
                    suburbText,
                    zipCodeText,
                    municipalityText,
                    stateText,
                    countryText
            );
            genderGroup.clearSelection();
            clearAllFields(allJTextField);
            firstNameText.requestFocus();
        });

        submitBtn.addActionListener(e -> {

            String firstName = firstNameText.getText();
            String firstSecondName = firstSecondNameText.getText();
            String lastName = lastNameText.getText();
            String secondLastName = secondLastnameText.getText();
            String birthdate = datePicker.getJFormattedTextField().getText();
            String gender = validateGender(genderGroup);
            String email = emailText.getText();
            String phone = phoneText.getText();

            String street = streetNameText.getText();
            String interiorNumber = interiorNumberText.getText();
            String exteriorNumber = exteriorNumberText.getText();
            String suburb = suburbText.getText();
            String zipCode = zipCodeText.getText();
            String municipality = municipalityText.getText();
            String state = stateText.getText();
            String country = countryText.getText();

            String query = String.format(
                    "INSERT INTO \"user\"(" +
                            "first_name, second_first_name, last_name, second_last_name, birth_date, gender, email, phone," +
                            "street_name, interior_number, exterior_number, suburb, zip_code, municipality, state_address, country)" +
                            "VALUES ('%s', '%s','%s','%s', '%s', '%s', '%s', '%s'," +
                            "'%s', '%s', '%s', '%s','%s', '%s', '%s', '%s');",
                    firstName,
                    firstSecondName,
                    lastName,
                    secondLastName,
                    birthdate,
                    gender,
                    email,
                    phone,

                    street,
                    interiorNumber,
                    exteriorNumber,
                    suburb,
                    zipCode,
                    municipality,
                    state,
                    country
            );

            try {
                new Connector().insertIntoTable(query);
                JOptionPane.showMessageDialog(
                        this.getTopLevelAncestor(),
                        "Usuario almacenado en base de datos!",
                        "ALTA DE USUARIO",
                        JOptionPane.INFORMATION_MESSAGE
                );
                List<JTextField> allJTextField = List.of(
                        firstNameText,
                        firstSecondNameText,
                        lastNameText,
                        secondLastnameText,
                        datePicker.getJFormattedTextField(),
                        emailText,
                        phoneText,

                        streetNameText,
                        interiorNumberText,
                        exteriorNumberText,
                        suburbText,
                        zipCodeText,
                        municipalityText,
                        stateText,
                        countryText
                );
                genderGroup.clearSelection();
                clearAllFields(allJTextField);
                firstNameText.requestFocus();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
    }

    private String validateGender(ButtonGroup bg) {
        String gender = "NO_GENDER";
        for (Enumeration<AbstractButton> btns = bg.getElements(); btns.hasMoreElements(); ) {
            AbstractButton btn = btns.nextElement();
            if (btn.isSelected()) {
                gender = btn.getText();
            }
        }
        return gender;
    }

    private void clearAllFields(List<JTextField> allJTextField) {
        String empty = "";
        allJTextField.forEach(
                (element) -> {
                    element.setText(empty);
                });
    }

}



