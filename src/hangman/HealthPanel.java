package hangman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HealthPanel extends JPanel {
    private ArrayList<JLabel> lifeLabels;
    private int maxLives;
    private int remainingLives;

    public HealthPanel(int maxLives) {
        this.maxLives = maxLives;
        this.remainingLives = maxLives;
        this.lifeLabels = new ArrayList<>();

        setPreferredSize(new Dimension(200, 50));
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

        for (int i = 0; i < maxLives; i++) {
            JLabel lifeLabel = new JLabel("❤️"); // Display this emoji as life symbol
            lifeLabel.setForeground(Color.GREEN);
            add(lifeLabel);
            lifeLabels.add(lifeLabel);
        }
    }
    public boolean removeLife() {
        if (remainingLives > 0) {
            for (JLabel lifeLabel : lifeLabels) {
                if (lifeLabel.getForeground().equals(Color.GREEN)) {
                    lifeLabel.setForeground(Color.RED);
                    remainingLives--;
                    return remainingLives == 0; // Return true if no remaining lives
                }
            }
        }
        return false;
    }  
    
    public void resetHealth() {   // Method to reset the health panel
        for (JLabel lifeLabel : lifeLabels) {
            lifeLabel.setForeground(Color.GREEN);
        }
        remainingLives = maxLives;
    }
}