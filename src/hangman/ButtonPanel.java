package hangman;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private WordPanel wordPanel;
    private MainWindow mainWindow; // Reference to the MainWindow

    public ButtonPanel(WordPanel wordPanel, MainWindow mainWindow) {
        this.wordPanel = wordPanel;
        this.mainWindow = mainWindow; // Initialize the reference
        setLayout(new GridLayout(7, 4)); // 7 rows and 4 columns for the buttons

        JButton[] buttons = new JButton[26];      // Create an array of buttons for alphabet
        for (char c = 'A'; c <= 'Z'; c++) {
            int index = c - 'A';
            buttons[index] = new JButton(String.valueOf(c));
            buttons[index].addActionListener(new ButtonListener());
            add(buttons[index]);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String letter = button.getText();
            boolean guessedCorrectly = wordPanel.guess(letter);
            button.setEnabled(false); // Disable the button after it's been clicked

            if (guessedCorrectly) {
                if (wordPanel.isWordGuessed()) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the word.");
                    resetGame(wordPanel.getWordToGuess());
                }
            } else {
                boolean gameOver = wordPanel.getHealthPanel().removeLife();
                if (gameOver) {
                    mainWindow.displayDefeatMessage(wordPanel.getWordToGuess());   // Display defeat message with try again option
                }
            }
        }
    }

    public void resetGame(String wordToGuess) {
    	
        String newWordToGuess = generateRandomWord();          // Generate a new random word

        wordPanel.resetWord(newWordToGuess);                   //reset wordpanel
        wordPanel.getHealthPanel().resetHealth();              //reset healthpaneldew

        // Enable all buttons
        for (Component component : getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(true);
            }
        }
    }

    private String generateRandomWord() {
        mainWindow.loadWordList("wordlist.txt");            // Reload word list from filee
        Random random = new Random();                       // Pick a random word from the word lsit
        return mainWindow.wordList.get(random.nextInt(mainWindow.wordList.size())).toUpperCase();
    }
}