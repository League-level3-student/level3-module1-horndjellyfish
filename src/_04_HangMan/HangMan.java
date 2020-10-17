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
    JFrame frame;
    char[] hangmanDisplayWord;
    char[] hiddenWord;
    char input;

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
        System.out.println(word);
        char lines = '_';
        for (int i = 0; i < hangmanDisplayWord.length; i++) {
            hangmanDisplayWord[i] = lines;
            display = display + hangmanDisplayWord[i] + " ";
        }
        Font font = new Font("Courier", Font.BOLD, 12);
        label.setFont(font);
        label.setText(display);
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.add(label);
        //frame.pack();
        guessLetter();
    }

    public void setText(char[] word) {
        String display = "";
        for (int i = 0; i < word.length; i++) {
            display = display + word[i] + " ";
        }
        label.setText(display);
    }

    public void guessLetter() {
        String inp = JOptionPane.showInputDialog("Guess a letter.");
        input = inp.charAt(0);
        ArrayList<Integer> newMatches = findMatches(input);
        if (newMatches.size() > 0) {
            populateLetters(newMatches, input);
            setText(hangmanDisplayWord);
        } else {
            // take off a life
        }
    }

    public void populateLetters(ArrayList<Integer> matches, char letter) {
       for (int i = 0; i < matches.size(); i++) {
            int small = matches.get(i).intValue();
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
