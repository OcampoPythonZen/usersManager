package edo.mex.gob.gui.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ButtonsPanel extends JPanel {
    JButton clearBtn;
    JButton cancelBtn;
    JButton submitBtn;

    public ButtonsPanel() {
        clearBtn = new JButton("Limpiar");
        cancelBtn = new JButton("Salir");
        submitBtn = new JButton("Guardar");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        setLayout(new GridBagLayout());

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(clearBtn, constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        add(cancelBtn, constraints);

        constraints.gridx = 5;
        constraints.gridy = 1;
        add(submitBtn, constraints);


        cancelBtn.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        });

        clearBtn.addActionListener(e -> {
            PersonalDataPanel pdp = new PersonalDataPanel();
            AddressDataPanel adp = new AddressDataPanel();
            String empty = "";
            this.getRootPane().getContentPane().getComponent(0).setBackground(Color.blue);
            //System.out.println(pd);
        });
    }
}
