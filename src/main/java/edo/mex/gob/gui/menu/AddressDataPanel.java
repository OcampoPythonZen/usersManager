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
        streetNameText = new JTextField(4);

        interiorNumberLabel = new JLabel("Numero Interior:");
        interiorNumberText = new JTextField(4);

        exteriorNumberLabel = new JLabel("Numero Exterior:");
        exteriorNumberText = new JTextField(4);

        suburbLabel = new JLabel("Colonia:");
        suburbText = new JTextField(4);

        zipCodeLabel = new JLabel("Codigo Postal:");
        zipCodeText = new JTextField(4);

        municipalityLabel = new JLabel("Municipio:");
        municipalityText = new JTextField(4);

        stateLabel = new JLabel("Estado:");
        stateText = new JTextField(4);

        countryLabel = new JLabel("Ciudad:");
        countryText = new JTextField(4);

        clearBtn = new JButton("Limpiar Datos");
        cancelBtn = new JButton("Cancelar");
        submitBtn = new JButton("Enviar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 20, 20, 20);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Direccion del Usuario"));

        setLayout(new GridBagLayout());

        add(streetNameLabel, constraints);
        add(streetNameText, constraints);

        add(interiorNumberLabel, constraints);
        add(interiorNumberText, constraints);

        add(exteriorNumberLabel, constraints);
        add(exteriorNumberText, constraints);

        add(suburbLabel, constraints);
        add(suburbText, constraints);

        add(zipCodeLabel, constraints);
        add(zipCodeText, constraints);

        add(municipalityLabel, constraints);
        add(municipalityText, constraints);

        add(stateLabel, constraints);
        add(stateText, constraints);

        add(countryLabel, constraints);
        add(countryText, constraints);

        add(clearBtn, constraints);
        add(cancelBtn, constraints);
        add(submitBtn, constraints);
        
    }
}
