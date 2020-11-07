package _06_Intro_To_Hash_Maps;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class _02_LogSearch implements ActionListener {

    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
     * 				After an ID is entered, use another input dialog to ask the user to enter a name.
     * 				Add this information as a new entry to your HashMap.
     *
     * Button 2: Search by ID
     * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
     * 				If that ID exists, display that name to the user.
     * 				Otherwise, tell the user that that entry does not exist.
     *
     * Button 3: View List
     * 				When this button is clicked, display the entire list in a message dialog in the following format:
     * 				ID: 123  Name: Harry Howard
     * 				ID: 245  Name: Polly Powers
     * 				ID: 433  Name: Oliver Ortega
     * 				etc...
     *
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
     * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
     * 				is not in the list.
     *
     * */
    public static void main(String[] args) {
        _02_LogSearch ls = new _02_LogSearch();
        ls.createGUI();
    }

    int j;
    String a;
    HashMap<Integer, String> entries = new HashMap<Integer, String>();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton addEntry = new JButton("Add Entry");
    JButton search = new JButton("Search by ID");
    JButton viewList = new JButton("View List");
    JButton remove = new JButton("Remove Entry");


    public void createGUI() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addEntry.addActionListener(this);
        search.addActionListener(this);
        viewList.addActionListener(this);
        remove.addActionListener(this);
        panel.add(addEntry);
        panel.add(search);
        panel.add(viewList);
        panel.add(remove);
        frame.add(panel);
        frame.pack();

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addEntry)) {
            String s = JOptionPane.showInputDialog("Enter an ID number.");
            j = Integer.parseInt(s);
            a = JOptionPane.showInputDialog("Enter a name.");
            entries.put(j, a);
        }
        if (e.getSource().equals(search)) {
            String s = JOptionPane.showInputDialog("Enter an ID number.");
            j = Integer.parseInt(s);
            if (entries.containsKey(j)) {
                JOptionPane.showMessageDialog(null, entries.get(j));
            } else {
                JOptionPane.showMessageDialog(null, "That entry does not exist.");
            }
        }
        if (e.getSource().equals(viewList)) {
            String all = "";
            for (Integer i : entries.keySet()) {
                String name = entries.get(i);
                all += "ID: " + i + " Name: " + name + "\n";
            }
            JOptionPane.showMessageDialog(null, all);

        }
        if (e.getSource().equals(remove)) {
            String s = JOptionPane.showInputDialog("Enter an ID number.");
            j = Integer.parseInt(s);
            if (entries.containsKey(j)) {
                entries.remove(j);
            } else {
                JOptionPane.showMessageDialog(null, "That entry does not exist.");
            }
        }

    }
}