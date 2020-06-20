package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    // Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names".
    // When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
    // that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
    // all the names added to the list. Format the list as follows:
    // Guest #1: Bob Banders
    // Guest #2: Sandy Summers
    // Guest #3: Greg Ganders
    // Guest #4: Donny Doners
    JButton add;
    JButton view;
    ArrayList<String> names;
    //ArrayList<Integer> list;

    public static void main(String[] args) {
        _02_GuestBook gb = new _02_GuestBook();
        gb.createGUI();
        gb.createArrayList();
    }

    public void createArrayList() {
        names = new ArrayList<String>();
        names.add("Bob Banders");
        names.add("Sandy Summers");
        names.add("Greg Ganders");
        names.add("Donny Doners");
//        list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
    }

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        JPanel panel = new JPanel();
        add = new JButton();
        add.setText("Add Name");
        add.addActionListener(this);
        view = new JButton();
        view.setText("View Names");
        view.addActionListener(this);
        panel.add(add);
        panel.add(view);
        frame.add(panel);
        frame.pack();
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)) {
            String n = JOptionPane.showInputDialog("Please enter a name.");
            names.add(n);
            //list.add((list.size()+2));
        } else if (e.getSource().equals(view)) {
        	String output = "";
            for (int i = 0; i < names.size(); i++) {
            	String a = names.get(i);
            	
            	output += "Guest #" + (i+1) + ": " + a + "\n";
            }
            JOptionPane.showMessageDialog(null, output);
        }

    }
}
