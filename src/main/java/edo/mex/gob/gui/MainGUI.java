package edo.mex.gob.gui;


import edo.mex.gob.gui.home.HomeGUI;

import edo.mex.gob.repository.BatchSqlTables;
import java.sql.SQLException;

public class MainGUI {

    public static void main(String[] args) throws SQLException {
        new HomeGUI();
        BatchSqlTables.getInstance();
    }
}