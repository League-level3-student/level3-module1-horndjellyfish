package _04_HangMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class HangMan implements KeyListener {
    Stack<String> lines = new Stack<String>();
    JLabel label = new JLabel();
    JFrame frame;
    char[] letters;
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
        letters = word.toCharArray();
        String display = "";
        System.out.println(word);
        char lines = '_';
        String inp = JOptionPane.showInputDialog("Guess a letter.");
        char input = inp.charAt(0);
        for (int i = 0; i < letters.length; i++) {
            letters[i] = lines;
            display = display + letters[i] + " ";
            if (letters[i] == input) {
                
            }
        }
        Font font = new Font("Courier", Font.BOLD,12);
        label.setFont(font);
        label.setText(display);
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);

        frame.add(label);
        //frame.pack();

    }
    public void keyPressed(KeyEvent e) {
        char input = e.getKeyChar();
    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }
}
