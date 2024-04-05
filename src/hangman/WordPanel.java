package hangman;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel {
    private JLabel wordLabel;
    private String wordToGuess;
    private StringBuilder guessedWord;
    private HealthPanel healthPanel;

    public WordPanel(String wordToGuess, HealthPanel healthPanel) {
        this.wordToGuess = wordToGuess.toUpperCase();
        this.healthPanel = healthPanel;
        guessedWord = new StringBuilder(wordToGuess.replaceAll(".", "_ ")); // Replace each character with underscore

        wordLabel = new JLabel(guessedWord.toString());       // Initialize word label
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        setLayout(new FlowLayout()); // Set layout for WordPanel
        add(wordLabel);
    }

    public boolean guess(String letter) {
        boolean found = false;
        letter = letter.toUpperCase(); // Covert guessed letter to Uppercase
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter.charAt(0)) {
                guessedWord.setCharAt(i * 2, letter.charAt(0));
                found = true;
            }
        }
        wordLabel.setText(guessedWord.toString());
        return found;
    }

    public boolean isWordGuessed() {
        return guessedWord.indexOf("_") == -1;
    }

    public HealthPanel getHealthPanel() {
        return healthPanel;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void resetWord(String newWordToGuess) {
        this.wordToGuess = newWordToGuess.toUpperCase();
        guessedWord = new StringBuilder(newWordToGuess.replaceAll(".", "_ "));
        wordLabel.setText(guessedWord.toString());
    }
}