//package _01_IntroToArrayLists;
//
//
////Copyright The League of Amazing Programmers, 2015
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class _06_IPodShuffle implements ActionListener {
//	ArrayList<Song> songs = new ArrayList<Song>();
//	JFrame frame = new JFrame();
//	JPanel panel = new JPanel();
//	JButton song1 = new JButton();
//	JButton song2 = new JButton();
//	JButton song3 = new JButton();
//	JButton song4 = new JButton();
//	JButton song5 = new JButton();
//	JButton song6 = new JButton();
//	JButton surprise = new JButton();
//	JButton stop = new JButton();
//	public _06_IPodShuffle() {
//		// 1. Use the Song class the play the demo.mp3 file.
//		//new Song ("demo.mp3").play();
//
//		/**
//		 * 2. Congratulations on completing the sound check! * Now we want to make an
//		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
//		 * "Surprise Me!" button that will play a random song when it is clicked. * If
//		 * you're really cool, you can stop all the songs, before playing a new one on
//		 * subsequent button clicks.
//		 */
//		songs.add(new Song ("Don'tGoWastingTime.mp3"));
//		songs.add(new Song ("GreySeal.mp3"));
//		songs.add(new Song ("HammerToFall.mp3"));
//		songs.add(new Song ("HeadOverHeels.mp3"));
//		songs.add(new Song ("SoTired.mp3"));
//		songs.add(new Song ("YourStarterFor.mp3"));
//
//	}
//
//	public static void main(String[] args) {
//		_06_IPodShuffle iPodShuffle = new _06_IPodShuffle();
//		iPodShuffle.createIPod();
//
//	}
//
//	public void createIPod() {
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		frame.setBounds(0, 0, 300, 400);
//		frame.setResizable(false);
//		frame.setTitle("iPod Shuffle");
//		song1.setText("Don't Go Wasting Time by Alfie Templeman");
//		song1.addActionListener(this);
//		song2.setText("Grey Seal by Elton John");
//		song2.addActionListener(this);
//		song3.setText("Hammer To Fall by Queen");
//		song3.addActionListener(this);
//		song4.setText("Head Over Heels by LoveLeo");
//		song4.addActionListener(this);
//		song5.setText("So Tired by Crumb");
//		song5.addActionListener(this);
//		song6.setText("Your Starter For... by Elton John");
//		song6.addActionListener(this);
//		surprise.setText("Surprise me!");
//		surprise.addActionListener(this);
//		stop.setText("Stop");
//		stop.addActionListener(this);
//		panel.add(song1);
//		panel.add(song2);
//		panel.add(song3);
//		panel.add(song4);
//		panel.add(song5);
//		panel.add(song6);
//		panel.add(surprise);
//		panel.add(stop);
//		frame.add(panel);
//	}
//
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource().equals(song1)) {
//			songs.get(0).play();
//		} else if (e.getSource().equals(song2)) {
//			songs.get(1).play();
//		} else if (e.getSource().equals(song3)) {
//			songs.get(2).play();
//		} else if (e.getSource().equals(song4)) {
//			songs.get(3).play();
//		} else if (e.getSource().equals(song5)) {
//			songs.get(4).play();
//		} else if (e.getSource().equals(song6)) {
//			songs.get(5).play();
//		} else if (e.getSource().equals(surprise)) {
//			Random random = new Random();
//				Song rsong = songs.get(random.nextInt(songs.size()));
//				rsong.play();
//		} else if (e.getSource().equals(stop)) {
//			for (int i = 0; i < songs.size(); i++) {
//				songs.get(i).stop();
//			}
//		}
//	}
//}