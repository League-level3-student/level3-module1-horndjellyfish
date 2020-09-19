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
    JLabel label = new JLabel();
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

    // update the label by adding text that was typed by user
    public void updateLabel(Stack<Character> c) {
        String s = stackToString();
        label.setText(s);
        frame.revalidate();
    }

    public void refreshLabel() {
        updateLabel(input);
    }
    // converts the stack input to a string to be able to set the label's text to the stack input
    public String stackToString() {
        asdf = new char[input.size()];
        for (int i = 0; i < input.size(); i++) {
            asdf[i] = input.get(i);
        }
        return new String(asdf);
    }


    public void keyTyped(KeyEvent e) {
        something = e.getKeyChar();
        // after getting the key, update the label with the new key
        // check to see if key was backspace, if so, delete the character typed before it and save it to another stack
        // if not backspace, update the label with the key

        if (something == KeyEvent.VK_BACK_SPACE) {
            // delete the last character typed and save it to the "deleted" stack
            char removed = input.pop();
            deleted.push(removed);
            refreshLabel();

        } else if (something == KeyEvent.VK_BACK_SLASH) {
            // pop the deleted stack and update the label with the popped off character
            input.push(deleted.pop());
            refreshLabel();
        } else {
            // update the label with the key typed
            input.push(something);
            refreshLabel();
        }
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
