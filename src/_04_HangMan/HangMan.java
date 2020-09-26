package _04_HangMan;

import javax.swing.*;
import java.util.Stack;

public class HangMan {
    Stack<String> lines = new Stack<String>();

    public static void main(String[] args) {
        HangMan hm = new HangMan();
        hm.getWords();
    }

    public void getWords() {
        String input = JOptionPane.showInputDialog("Enter a number.");
        int words = Integer.parseInt(input);
        for (int i = 0; i < words; i++) {
            String word = Utilities.readRandomLineFromFile("dictionary.txt");
            lines.push(word);
        }

    }

    public void createGame() {
        String word = lines.pop();
        JFrame frame = new JFrame();
        JLabel label = new JLabel(word);
        frame.add(label);
        frame.pack();

    }
}
