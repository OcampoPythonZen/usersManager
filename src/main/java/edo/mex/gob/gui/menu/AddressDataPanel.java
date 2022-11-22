package edo.mex.gob.gui.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressDataPanel extends JPanel {

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
    JButton clearBtn;
    JButton cancelBtn;
    JButton submitBtn;

    public AddressDataPanel() {

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

        clearBtn = new JButton("Limpiar");
        cancelBtn = new JButton("Cancelar");
        submitBtn = new JButton("Guardar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 20, 20, 20);
        setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(streetNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(streetNameText, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add(interiorNumberLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(interiorNumberText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        add(exteriorNumberLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        add(exteriorNumberText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(suburbLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        add(suburbText, constraints);

        constraints.gridx = 4;
        constraints.gridy = 3;
        add(zipCodeLabel, constraints);

        constraints.gridx = 5;
        constraints.gridy = 3;
        add(zipCodeText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(municipalityLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        add(municipalityText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(stateLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        add(stateText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        add(countryLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 10;
        add(countryText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 13;
        add(clearBtn, constraints);

        constraints.gridx = 3;
        constraints.gridy = 13;
        add(cancelBtn, constraints);

        constraints.gridx = 5;
        constraints.gridy = 13;
        add(submitBtn, constraints);

    }
}
