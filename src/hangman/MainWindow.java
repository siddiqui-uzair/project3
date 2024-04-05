package hangman;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainWindow extends JFrame {
    private HealthPanel healthPanel;
    private WordPanel wordPanel;
    private ButtonPanel buttonPanel;
    public List<String> wordList;

    public MainWindow() {
        setTitle("Hangman Game");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        healthPanel = new HealthPanel(6); // Number of lives the user can have before defeat

        loadWordList("wordlist.txt");        // Load word list from file

        Random random = new Random();        // Pick a random word from the word list
        String wordToGuess = wordList.get(random.nextInt(wordList.size()));

        wordPanel = new WordPanel(wordToGuess, healthPanel);        // Initialize WordPanel

        buttonPanel = new ButtonPanel(wordPanel, this);             // Initialize ButtonPanel

        setLayout(new BorderLayout());        // Set layout for MainWindow

        add(healthPanel, BorderLayout.NORTH);
        add(wordPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    void loadWordList(String filename) {    // Method to load word list from file

        wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line.trim().toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayVictoryMessage(String wordToGuess) {    // Method to display victory message

        int choice = JOptionPane.showConfirmDialog(this, "Congratulations! You guessed the word: " + wordToGuess + "\nDo you want to play again?", "Victory!", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    public void displayDefeatMessage(String wordToGuess) {    // Method to display defeat message
    	
        int choice = JOptionPane.showOptionDialog(this,
                "You lost! The word was: " + wordToGuess + "\nDo you want to try again?",
                "Defeat!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Try Again", "Quit"},
                "default");

        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
            buttonPanel.resetGame(wordToGuess);    // Enable all buttons
        } else {
            System.exit(0);
        }
    }
    private void resetGame() {                     // Method to reset the game

        loadWordList("wordlist.txt");

        Random random = new Random();              // Pick a random word from the word list
 
        String wordToGuess = wordList.get(random.nextInt(wordList.size()));

        wordPanel.resetWord(wordToGuess);          // Reset WordPanel and HealthPanel
        healthPanel.resetHealth();

        wordPanel.resetWord(wordToGuess);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
}
