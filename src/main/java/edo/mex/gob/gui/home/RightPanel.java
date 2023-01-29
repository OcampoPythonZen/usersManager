package edo.mex.gob.gui.home;

import edo.mex.gob.gui.menu.MenuGUI;
import edo.mex.gob.repository.Connector;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
        constraints.anchor = GridBagConstraints.CENTER;
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

        cancel.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
            System.exit(0);
        });

        access.addActionListener(e -> {

            String user = userTextField.getText();
            String pass = String.valueOf(passwordTextField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this.getTopLevelAncestor(),
                        "Usuario y Contraseña son mandatorios!",
                        "NO AUTENTICADO",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                String query = String.format(
                        "SELECT user_login, password_login FROM login WHERE user_login = '%s' AND password_login = '%s' ORDER BY created_at DESC LIMIT 1;",
                        user,
                        pass
                );
                try {
                    ResultSet rs = new Connector().resultSetConn(query);
                    String userRs = "";
                    String passRs = "";

                    while (rs.next()) {
                        userRs = rs.getString("user_login");
                        passRs = rs.getString("password_login");
                    }

                    if (userRs.equals(user) && passRs.equals(pass)) {
                        JOptionPane.showMessageDialog(
                                this.getTopLevelAncestor(),
                                "Credenciales Validas para este Usuario!",
                                "BIENVENIDA",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        this.setVisible(false);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                        frame.dispose();
                        new MenuGUI().setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(
                                this.getTopLevelAncestor(),
                                "Credenciales invalidas!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }
}
