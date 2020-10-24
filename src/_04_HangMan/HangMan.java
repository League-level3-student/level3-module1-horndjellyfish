package _04_HangMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

public class HangMan implements KeyListener {
    Stack<String> lines = new Stack<String>();
    JLabel label = new JLabel();
    JLabel livesLabel = new JLabel();
    JPanel panel1 = new JPanel();
    JFrame frame;
    char[] hangmanDisplayWord;
    char[] hiddenWord;
    char input;
    int livesLeft = 6;

    public static void main(String[] args) {
        HangMan hm = new HangMan();
        hm.getWords();
        hm.createGame();
    }

    public void getWords() {
        String input = JOptionPane.showInputDialog("Enter a number (up to 266).");
        int words = Integer.parseInt(input);
        for (int i = 0; i < words; i++) {
            String word = Utilities.readRandomLineFromFile("dictionary.txt");
            if (!lines.contains(word)) {
                lines.push(word);
            }
        }

    }

    public void createGame() {
        String word = lines.pop();
        hangmanDisplayWord = word.toCharArray();
        hiddenWord = word.toCharArray();
        String display = "";
        //System.out.println(word);
        char lines = '_';
        for (int i = 0; i < hangmanDisplayWord.length; i++) {
            hangmanDisplayWord[i] = lines;
            display = display + hangmanDisplayWord[i] + " ";
        }
        label.setText(display);
        livesLabel.setText("lives left: " + livesLeft);
        panel1.setLayout(new BorderLayout());
        panel1.add(label);
        panel1.add(livesLabel, BorderLayout.NORTH);
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.add(panel1);
        guessLetter();
    }

    public void setText(char[] word) {
        String display = "";
        for (char c : word) {
            display = display + c + " ";
        }
        label.setText(display);
    }

    public boolean wordCompleted() {
        boolean complete = false;
        if (!(new String(hangmanDisplayWord).contains("_"))) {
            complete = true;
        }
        return complete;
    }

    public boolean stillAlive() {
        boolean alive = true;
        if (livesLeft <= 0) {
            alive = false;
        }
        return alive;
    }

    public void guessLetter() {
        while (!gameOver()) {
            String inp = JOptionPane.showInputDialog("Guess a letter.");
            input = inp.charAt(0);
            ArrayList<Integer> newMatches = findMatches(input);
            if (newMatches.size() > 0) {
                populateLetters(newMatches, input);
                setText(hangmanDisplayWord);
            } else {
                takeOffLife();
            }
        }
    }

    public void takeOffLife() {
        livesLeft--;
        livesLabel.setText("lives left: " + livesLeft);
    }

    public boolean gameOver() {
        boolean endgame = false;
        if (wordCompleted()) {
            endgame = true;
            frame.dispose();
            JOptionPane.showMessageDialog(null, "YOU WON!!!!! CONGRATULATIONS!!!");
        } else if (!stillAlive()) {
            endgame = true;
            frame.dispose();
            JOptionPane.showMessageDialog(null, "GAME OVER! :(");
        }

        return endgame;
    }

    public void populateLetters(ArrayList<Integer> matches, char letter) {
        for (int small : matches) {
            hangmanDisplayWord[small] = letter;
        }
    }

    public ArrayList<Integer> findMatches(char letter) {
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] == letter) {
                matches.add(i);
            }
        }

        return matches;
    }

    public void keyPressed(KeyEvent e) {
        //input = e.getKeyCode();

    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }
}
