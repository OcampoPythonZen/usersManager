package edo.mex.gob.gui.menu;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class MenuGUI extends JFrame {

    ImageLeftPanel ilp = new ImageLeftPanel();
    CreateUserPanel cup = new CreateUserPanel();

    public MenuGUI() {

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(1, 2));

        String title = "Alta de Usuarios  - Tlalnepantla Estado de Mexico";
        setTitle(title);

        setResizable(false);

        contentPane.add(ilp, BorderLayout.WEST);
        contentPane.add(cup, BorderLayout.EAST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
