package edo.mex.gob.gui.menu;

import edo.mex.gob.gui.assignment.AssignmentFrame;
import edo.mex.gob.gui.course.CourseGUI;
import edo.mex.gob.gui.home.HomeGUI;
import edo.mex.gob.gui.user.UserGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class MenuGUI extends JFrame {

    JButton userBtn, courseBtn, assignBtn, exitBtn;

    public MenuGUI() {


        String title = "Menu Tlalnepantla";
        setTitle(title);
        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension screenSize = myScreen.getScreenSize();
        setBounds(
                screenSize.width / 4,
                screenSize.height / 4,
                screenSize.width / 2,
                screenSize.height / 2
        );
        getContentPane().setLayout(new FlowLayout());



        userBtn = new JButton("Crear Usuario");
        courseBtn = new JButton("Crear Curso");
        assignBtn = new JButton("Asignacion");
        exitBtn = new JButton("Salir");


        Image asignacionImg, cursosImg, usuarioImg, salirImg;

        try {
            asignacionImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/crear.png")));
            cursosImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/curso.png")));
            usuarioImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/asignar.png")));
            salirImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/salir.png")));

        } catch (IOException e) {
            throw new RuntimeException(e + "We cannot access to this image!");

        }

        userBtn.setIcon(new ImageIcon(asignacionImg));
        userBtn.setBackground(null);
        userBtn.setBorder(null);
        userBtn.setContentAreaFilled(false);


        courseBtn.setIcon(new ImageIcon(cursosImg));
        courseBtn.setBackground(null);
        courseBtn.setBorder(null);
        courseBtn.setContentAreaFilled(false);


        assignBtn.setIcon(new ImageIcon(usuarioImg));
        assignBtn.setBackground(null);
        assignBtn.setBorder(null);
        assignBtn.setContentAreaFilled(false);


        exitBtn.setIcon(new ImageIcon(salirImg));
        exitBtn.setBackground(null);
        exitBtn.setBorder(null);
        exitBtn.setContentAreaFilled(false);


        add(userBtn, BorderLayout.WEST);
        add(courseBtn, BorderLayout.NORTH);
        add(assignBtn, BorderLayout.CENTER);
        add(exitBtn, BorderLayout.EAST);

        userBtn.addActionListener(e -> {
            setVisible(false);
            new UserGUI().setVisible(true);

        });

        courseBtn.addActionListener(e -> {
            setVisible(false);
            new CourseGUI().setVisible(true);

        });

        assignBtn.addActionListener(e -> {
            setVisible(false);
            new AssignmentFrame().setVisible(true);
        });

        exitBtn.addActionListener(e -> {
            setVisible(false);
            new HomeGUI().setVisible(true);

        });




        setResizable(false);
        setVisible(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();


    }

}


