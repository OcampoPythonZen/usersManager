package edo.mex.gob.gui.menu;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;

public class MenuGUI extends JFrame {

    JButton Btn1, Btn2, Btn3,Btn4;

    public MenuGUI(){


        String title = "Menu Tlalnepantla";
        setTitle(title);
        Container contentPane = getContentPane();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        contentPane.setLayout(new GridBagLayout());

        Btn1 = new JButton("Crear Usuario");
        Btn2 = new JButton("Crear Curso");
        Btn3 = new JButton("Asignacion");
        Btn4 = new JButton("Salir");


        add(Btn1, constraints);
        add(Btn2, constraints);
        add(Btn3, constraints);
        add(Btn4,constraints);

        setVisible(true);




    }

 }


