package edo.mex.gob.gui.assignment;

import edo.mex.gob.repository.Connector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AssignmentFrameLogic {

    String getCoursesQuery = "select course_name from course;";
    String getUsersQuery =
            "select id_user, first_name, second_first_name, last_name, second_last_name, phone, email from public.user;";

    String[] usersColumnsNames =
            {"ID", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Telefono", "Correo Electronico"};
    Vector<String> usersColumnsNamesV = new Vector<>(List.of(usersColumnsNames));


    private DefaultTableModel newModel;


    public void addCoursesItemToBox(JComboBox<String> box) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                ResultSet rs = new Connector().resultSetConn(getCoursesQuery);
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
                String[] columnsNames =
                        {"ID", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Telefono", "Correo Electronico"};
                Vector<String> columnsNamesV = new Vector<>(Arrays.asList(columnsNames));
                newModel = new DefaultTableModel(columnsNamesV, 0);
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
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
            }
        });
    }


}
