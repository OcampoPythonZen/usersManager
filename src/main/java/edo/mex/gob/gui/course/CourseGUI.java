package edo.mex.gob.gui.course;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CourseGUI extends JFrame {

    CourseLeftPanel clp = new CourseLeftPanel();
    CreateCoursePanel ccp = new CreateCoursePanel();

    public CourseGUI() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(1, 2));

        String title = "Sistema de Alta de Cursos - Tlalnepantla Estado de Mexico";
        setTitle(title);

        setResizable(false);

        contentPane.add(clp, BorderLayout.WEST);
        contentPane.add(ccp, BorderLayout.EAST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
