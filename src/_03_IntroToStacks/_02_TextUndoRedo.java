package _03_IntroToStacks;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class _02_TextUndoRedo implements KeyListener {

    /*
     * Create a JFrame with a JPanel and a JLabel.
     *
     * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
     *
     * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
     * Save that deleted character onto a Stack of Characters.
     *
     * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped
     * off the Stack and added back to the JLabel.
     *
     * */
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("something is here");
    char something;
    char[] asdf;
    Stack<Character> input = new Stack<Character>();
    Stack<Character> deleted = new Stack<Character>();

    public static void main(String[] args) {
        _02_TextUndoRedo tur = new _02_TextUndoRedo();
        tur.createFrame();
    }

    public void createFrame() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.addKeyListener(this);
        panel.add(label);
        frame.add(panel);
//		frame.pack();

    }

    public void updateLabel(char c) {
        String text = Character.toString(c);
        label.setText(text);
        frame.revalidate();
    }

    public void updateLabel(Stack<Character> c) {
        label.setText(stackToString());
        frame.revalidate();
    }

    public String stackToString() {
        asdf = new char[input.size()];
        for (int i = 0; i < input.size(); i++) {
            asdf[i] = input.get(i);
        }
        return new String(asdf);
    }


    public void keyTyped(KeyEvent e) {
        something = e.getKeyChar();
        updateLabel(something);
        updateLabel(input);
        input.add(something);
        else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            deleted.add(something);
        }
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
