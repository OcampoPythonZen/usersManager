package edo.mex.gob.gui.home;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class HomeGUI extends JFrame {

    LeftPanel lp = new LeftPanel();
    RightPanel rp = new RightPanel();

    public HomeGUI() {

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(1, 2));

        String title = "Sistema de Alta de Usuarios a los Cursos - Tlalnepantla Estado de Mexico";
        setTitle(title);

        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension screenSize = myScreen.getScreenSize();
        setBounds(
                screenSize.width / 4,
                screenSize.height / 4,
                screenSize.width / 2,
                screenSize.height / 2
        );

        setResizable(false);

        contentPane.add(lp, BorderLayout.WEST);
        contentPane.add(rp, BorderLayout.EAST);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
