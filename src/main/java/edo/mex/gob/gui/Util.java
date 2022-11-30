package edo.mex.gob.gui;

import java.util.List;
import javax.swing.JTextField;

public class Util {

    public static void clearAllFields(List<JTextField> allJTextField) {
        String empty = "";
        allJTextField.forEach(
                (element) -> {
                    element.setText(empty);
                });
    }
}
