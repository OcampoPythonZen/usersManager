package edo.mex.gob.gui.assignment;

import edo.mex.gob.repository.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class AssignmentFrameLogic {

    public void getCourses(String query, JComboBox<String> box) {
        try {
            ResultSet rs = new Connector().resultSetConn(query);
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                box.addItem(courseName);
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
                model.addRow(new Object[]{
                        id,
                        firstName,
                        secondFirstName,
                        lastName,
                        secondLastName,
                        phone,
                        email});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
