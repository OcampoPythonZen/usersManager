package edo.mex.gob.gui.assignment;

import edo.mex.gob.repository.Connector;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AssignmentFrame extends JFrame {

    JLabel labelUser;
    JTextField searchUserField;

    JLabel coursesLabel;
    JComboBox<String> coursesBox;

    JTable usersTable;
    JTable userAddedTable;
    JTable coursesTable;

    JButton addUser;
    JButton addCourse;

    JButton deleteUser;
    JButton deleteCourse;

    JButton saveBtn;
    JButton sentEmailBtn;
    JButton closeBtn;

    String getCoursesQuery = "select course_name from course;";
    String getFilterUsersQuery =
            "select id_user, first_name, second_first_name, last_name, second_last_name, email from public.user;";
    String[] columnsNames =
            {"Id", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Correo Electronico"};

    public AssignmentFrame() {

        String title = "Cursos/Usuarios  - Tlalnepantla Estado de Mexico";
        setTitle(title);

        Container contentPane = getContentPane();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        contentPane.setLayout(new GridBagLayout());

        labelUser = new JLabel("Busqueda de usuario:");
        searchUserField = new JTextField(16);
        coursesLabel = new JLabel("Selecciona el Curso:");
        coursesBox = new JComboBox<String>();

        usersTable = new JTable();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnsNames);

        usersTable.setModel(model);
        usersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        usersTable.setFillsViewportHeight(false);
        JScrollPane scroll = new JScrollPane(usersTable);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        getUsers(getFilterUsersQuery, model);
        getCourses(getCoursesQuery);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelUser, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(searchUserField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add(coursesLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(coursesBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        add(scroll, constraints);


        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void getCourses(String query) {
        try {
            ResultSet rs = new Connector().resultSetConn(query);
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                coursesBox.addItem(courseName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUsers(String query, DefaultTableModel model) {
        try {
            ResultSet rs = new Connector().resultSetConn(query);
            while (rs.next()) {
                String id = rs.getString("id_user");
                String firstName = rs.getString("first_name");
                String secondFirstName = rs.getString("second_first_name");
                String lastName = rs.getString("last_name");
                String secondLastName = rs.getString("second_last_name");
                String email = rs.getString("email");
                model.addRow(new Object[]{id, firstName, secondFirstName, lastName, secondLastName, email});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
