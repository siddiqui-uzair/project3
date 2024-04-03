package hangman;
import javax.swing.*;


public class Run extends JFrame {
    private HealthPanel healthPanel;

    public Run() {
        setTitle("Hangman Game");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        healthPanel = new HealthPanel(3); // This gives you 3 lives
        getContentPane().add(healthPanel); // Adding health panel to the content pane

        setVisible(true);
    }

    public static void main(String[] args) {
            new Run();
        };
    }
