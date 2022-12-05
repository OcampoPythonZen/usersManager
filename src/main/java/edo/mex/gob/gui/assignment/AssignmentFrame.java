package edo.mex.gob.gui.assignment;

import edo.mex.gob.repository.Connector;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AssignmentFrame extends JFrame {

    JLabel labelUser;
    JTextField searchUserField;

    JLabel coursesLabel;
    JComboBox<String> coursesBox;

    JTable usersTable;
    JTable coursesTable;

    JButton add;
    JButton delete;
    JButton save;
    JButton close;

    String getCourses = "select course_name from course;";

    public AssignmentFrame() {

        String title = "Cursos/Usuarios  - Tlalnepantla Estado de Mexico";
        setTitle(title);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        labelUser = new JLabel("Busqueda de usuario:");
        searchUserField = new JTextField(16);
        coursesLabel = new JLabel("Selecciona el Curso:");
        coursesBox = new JComboBox<String>();
        try {

            ResultSet rs = new Connector().resultSetConn(getCourses);
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                coursesBox.addItem(courseName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        add(labelUser);
        add(searchUserField);
        add(coursesLabel);
        add(coursesBox);

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
