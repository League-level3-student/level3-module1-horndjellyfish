package _04_HangMan;

import javax.swing.*;
import java.util.Stack;

public class HangMan {
    Stack<String> lines = new Stack<String>();
    JLabel label;
    JFrame frame;
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
            lines.push(word);
        }

    }

    public void createGame() {
        String word = lines.pop();
        char[] letters = word.toCharArray();
        label = new JLabel(word);
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(label);
        //frame.pack();

    }
}
