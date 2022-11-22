package edo.mex.gob.gui.menu;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class MenuGUI extends JFrame {

    PersonalDataPanel pdp = new PersonalDataPanel();
    AddressDataPanel adp = new AddressDataPanel();

    public MenuGUI() {

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 1));

        String title = "Alta de Usuarios  - Tlalnepantla Estado de Mexico";
        setTitle(title);

        setResizable(false);

        contentPane.add(pdp);
        contentPane.add(adp);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
