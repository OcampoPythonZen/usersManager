package edo.mex.gob.gui.home;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RightPanel extends JPanel {

    JLabel userLabel;
    JTextField userTextField;
    JLabel passwordLabel;
    JPasswordField passwordTextField;
    JButton access;
    JButton cancel;

    public RightPanel() {
        userLabel = new JLabel("Usuario:");
        userTextField = new JTextField(8);
        passwordLabel = new JLabel("Password:");
        passwordTextField = new JPasswordField(8);
        access = new JButton("Accesar");
        cancel = new JButton("Cancelar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 20, 20, 20);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Acceso al Usuario"));

        setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(userLabel, constraints);

        constraints.gridx = 1;
        add(userTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(passwordLabel, constraints);

        constraints.gridx = 1;
        add(passwordTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(access, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        add(cancel, constraints);
    }

}
