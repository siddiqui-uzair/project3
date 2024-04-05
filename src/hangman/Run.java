package hangman;

import javax.swing.SwingUtilities;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setTitle("Hangman Game");
            mainWindow.setSize(600, 400);
            mainWindow.setVisible(true);
        });
    }
}