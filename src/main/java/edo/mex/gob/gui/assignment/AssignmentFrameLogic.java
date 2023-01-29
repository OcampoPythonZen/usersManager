package edo.mex.gob.gui.assignment;

import static edo.mex.gob.mail.EmailSender.sendEmail;
import edo.mex.gob.repository.Connector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AssignmentFrameLogic {

    String getCoursesQueryNames = "SELECT course_name FROM public.course;";
    String getUsersQuery =
            "SELECT id_user, first_name, second_first_name, last_name, second_last_name, phone, email FROM public.user;";
    String getCourseInfo = "SELECT * FROM public.course";

    String manyToMany = "INSERT INTO public.users_courses(user_id, course_id) VALUES (?, ?)";

    String[] usersColumnsNames =
            {"ID", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Telefono", "Correo Electronico"};
    Vector<String> usersColumnsNamesV = new Vector<>(List.of(usersColumnsNames));

    String[] coursesColumnsNames =
            {"ID", "Nombre Curso", "Fecha de Inicio", "Fecha de Termino", "Hora de Inicio", "Hora de Termino", "Lugar", "Info"};
    Vector<String> coursesColumnsNamesV = new Vector<>(List.of(coursesColumnsNames));


    private DefaultTableModel newModel;

    public void addCoursesItemToBox(JComboBox<String> box) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                ResultSet rs = new Connector().resultSetConn(getCoursesQueryNames);
                while (rs.next()) {
                    String courseName = rs.getString("course_name");
                    box.addItem(courseName);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    void setModelOnTableUsers(JTable table) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                ResultSet rs = new Connector().resultSetConn(getUsersQuery);
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Vector<Vector<Object>> data = new Vector<>();
                while (rs.next()) {
                    Vector<Object> vectorValues = new Vector<>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vectorValues.add(rs.getObject(columnIndex));
                    }
                    data.add(vectorValues);
                }
                SwingUtilities.invokeLater(() -> model.setDataVector(data, usersColumnsNamesV));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    void addUserToKeepOnNewTable(JTable source, JTable destination) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            if (newModel == null) {
                newModel = new DefaultTableModel(usersColumnsNamesV, 0);
                destination.setModel(newModel);
            }
            TableModel model = source.getModel();
            int[] selectedRows = source.getSelectedRows();
            int columnCount = source.getColumnCount();
            for (int selectedRow : selectedRows) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                    row[columnIndex] = model.getValueAt(selectedRow, columnIndex);
                }
                SwingUtilities.invokeLater(() -> newModel.addRow(row));
            }
        });
    }

    void deleteRow(JTable table) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            List<Integer> selectedRows =
                    Arrays.stream(table.getSelectedRows()).boxed().sorted(Collections.reverseOrder())
                            .collect(Collectors.toList());
            for (int row : selectedRows) {
                model.removeRow(row);
            }
        });
    }

    void fillJTableByComboItem(String selectedItem, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(coursesColumnsNamesV);
        try {
            Connector connector = new Connector();
            ResultSet rs = connector.resultSetConn(getCourseInfo);
            while (rs.next()) {
                Long courseId = rs.getLong("id_course");
                String courseName = rs.getString("course_name");
                String initialDate = rs.getString("initial_date");
                String finalDate = rs.getString("final_date");
                String initialHour = rs.getString("initial_hour");
                String finalHour = rs.getString("final_hour");
                String coursePlace = rs.getString("course_place");
                String courseInfo = rs.getString("course_info");
                if (courseName.equals(selectedItem)) {
                    model.addRow(new Object[]{courseId, courseName, initialDate, finalDate, initialHour, finalHour, coursePlace, courseInfo});
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void filterData(JTable table, JTextField jTextField) {
        String wordToFilter = jTextField.getText();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        if (wordToFilter.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + wordToFilter));
        }
        jTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                filterData(table, jTextField);
            }
        });
    }

    public void getAllDataToSendEmail(JTable userTable, JTable courseTable) {
        String subject = "Informacion de Cursos - Tlalnepantla Estado de Mexico";
        DefaultTableModel userModel = (DefaultTableModel) userTable.getModel();
        DefaultTableModel courseModel = (DefaultTableModel) courseTable.getModel();
        List<String> emails = getList(userModel, "Correo Electronico");
        String info = getAllInfo(courseModel);
        for (String email : emails) {
            sendEmail(email, subject, info);
        }
    }

    private List<String> getList(DefaultTableModel model, String columnName) {
        List<String> data = new ArrayList<String>();
        int columnIndex = -1;
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(columnName)) {
                columnIndex = i;
                break;
            }
        }
        if (columnIndex != -1) {
            for (int count = 0; count < model.getRowCount(); count++) {
                data.add(model.getValueAt(count, columnIndex).toString());
            }
        }
        return data;
    }

    private String getAllInfo(DefaultTableModel model) {
        StringBuilder info = new StringBuilder();
        for (int count = 0; count < model.getRowCount(); count++) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                info.append(model.getColumnName(i) + ": " + model.getValueAt(count, i) + "\n");
            }
            info.append("\n");
        }
        return info.toString();
    }

    public void saveOnDb(JTable jTableUsers, JTable jTableCourses) {
        DefaultTableModel userModel = (DefaultTableModel) jTableUsers.getModel();
        DefaultTableModel courseModel = (DefaultTableModel) jTableCourses.getModel();

        try {
            for (int i = 0; i < userModel.getRowCount(); i++) {
                for (int j = 0; j < courseModel.getRowCount(); j++) {
                    Integer userId = ((Long) userModel.getValueAt(i, 0)).intValue();
                    Integer courseId = ((Long) courseModel.getValueAt(j, 0)).intValue();
                    new Connector().insertIntoTable(manyToMany, userId, courseId);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
