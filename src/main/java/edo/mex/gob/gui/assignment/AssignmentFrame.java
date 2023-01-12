package edo.mex.gob.gui.assignment;

import edo.mex.gob.gui.menu.MenuGUI;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AssignmentFrame extends JFrame {

    JLabel labelUser;
    JTextField searchUserField;

    JLabel coursesLabel;
    JComboBox<String> coursesBox;

    JTable usersTable;
    JTable userAddedTable;
    JTable coursesTable;

    TableRowSorter trs;

    JButton addUser;
    JButton addCourse;

    JButton deleteUser;
    JButton deleteCourse;

    JButton saveBtn;
    JButton sentEmailBtn;
    JButton closeBtn;

    String getCoursesQuery = "select course_name from course;";
    String getFilterUsersQuery =
            "select id_user, first_name, second_first_name, last_name, second_last_name, phone, email from public.user;";
    String[] usersColumnsNames =
            {"Id", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Telefono", "Correo Electronico"};

    String[] coursesColumnsNames =
            {"Id", "Nombre del Curso", "Fecha de Inicio", "Fecha de Termino", "Hora de Inicio", "Hora de termino", "Lugar", "Info"};

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
        userAddedTable = new JTable();
        coursesTable = new JTable();

        DefaultTableModel model = new DefaultTableModel();
        setTablesProperties(usersColumnsNames, model, usersTable);

        //JScrollPane scrollUserTable = new JScrollPane(usersTable);
        //scrollUserTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //scrollUserTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //Buttons
        addUser = new JButton("Agregar Usuario");
        deleteUser = new JButton("Eliminar Usuario");
        addCourse = new JButton("Agregar Curso");
        deleteCourse = new JButton("Eliminar Curso");
        saveBtn = new JButton("Guardar");
        sentEmailBtn = new JButton("Enviar Correo");
        closeBtn = new JButton("Salir");

        getUsers(getFilterUsersQuery, model);
        getCourses(getCoursesQuery);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelUser, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(searchUserField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 13;
        add(coursesLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 13;
        add(coursesBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(usersTable, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        add(addUser, constraints);

        constraints.gridx = 4;
        constraints.gridy = 1;
        add(deleteUser, constraints);

        constraints.gridx = 4;
        constraints.gridy = 13;
        add(addCourse, constraints);

        constraints.gridx = 4;
        constraints.gridy = 14;
        add(deleteCourse, constraints);

        constraints.gridx = 0;
        constraints.gridy = 21;
        add(saveBtn, constraints);

        constraints.gridx = 2;
        constraints.gridy = 21;
        add(sentEmailBtn, constraints);

        constraints.gridx = 4;
        constraints.gridy = 21;
        add(closeBtn, constraints);

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        closeBtn.addActionListener(e -> {
            this.dispose();
            new MenuGUI().setVisible(true);
        });


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
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                model.addRow(new Object[]{id, firstName, secondFirstName, lastName, secondLastName, phone, email});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTablesProperties(String[] columns, DefaultTableModel model, JTable table) {
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFillsViewportHeight(true);
    }

}
