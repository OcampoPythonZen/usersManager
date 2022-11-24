package edo.mex.gob.gui.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftPanel extends JPanel {

    JButton imageButton;
    JLabel welcomeLabel;
    JLabel welcomeLabel2;

    public LeftPanel() {

        imageButton = new JButton();
        welcomeLabel = new JLabel();
        welcomeLabel2 = new JLabel();

        welcomeLabel.setText("Bienvenidos al Sistema de Registros");
        welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 22));
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        welcomeLabel2.setText("TLALNEPANTLA  -  ESTADO DE MEXICO.");
        welcomeLabel2.setFont(new Font("Calibri", Font.BOLD, 18));
        welcomeLabel2.setForeground(Color.RED);
        welcomeLabel2.setHorizontalAlignment(JLabel.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        Image img;
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/tlalnepantla.png")));
        } catch (IOException e) {
            throw new RuntimeException(e + "We cannot access to this image!");
        }
        imageButton.setIcon(new ImageIcon(img));
        imageButton.setBackground(null);
        imageButton.setBorder(null);
        imageButton.setContentAreaFilled(false);


        setLayout(new GridBagLayout());


        constraints.gridx = 0;
        constraints.gridy = 0;
        add(imageButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(welcomeLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(welcomeLabel2, constraints);
    }
}
