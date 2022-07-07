import ui.MainWindow;

import javax.swing.*;

public class SwingApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new MainWindow();
            }
        });;
    }
}
