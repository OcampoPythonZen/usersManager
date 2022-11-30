package edo.mex.gob.gui;


import edo.mex.gob.gui.course.CourseGUI;
import edo.mex.gob.gui.home.HomeGUI;
import edo.mex.gob.gui.user.UserGUI;
import edo.mex.gob.repository.BatchSqlTables;
import java.sql.SQLException;

public class MainGUI {

    public static void main(String[] args) throws SQLException {
        CourseGUI c = new CourseGUI();
        HomeGUI main = new HomeGUI();
        UserGUI menu = new UserGUI();
       //BatchSqlTables sql = new BatchSqlTables();

    }
}