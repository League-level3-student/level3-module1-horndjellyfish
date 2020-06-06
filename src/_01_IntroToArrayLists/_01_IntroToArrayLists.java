package _01_IntroToArrayLists;

import java.awt.Window.Type;
import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> strings = new ArrayList<String>();
		//2. Add five Strings to your list
		strings.add("julia");
		strings.add("wendy");
		strings.add("ronald");
		strings.add("sebastian");
		strings.add("rey");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < strings.size(); i++) {
			String s = strings.get(i);
			System.out.println(s);
		}
		
		//4. Print all the Strings using a for-each loop
			for (String String : strings) {
				System.out.println(String);
			}
		//5. Print only the even numbered elements in the list.
			for (int i = 0; i < strings.size(); i++) {
				if (i % 2 == 0) {
					System.out.println(strings.get(i));
				}
			}
		//6. Print all the Strings in reverse order.
			for (int i = strings.size(); i > 0; i-- ) {
				System.out.println(strings.get(i - 1));
			}
		//7. Print only the Strings that have the letter 'e' in them.
			for (int i = 0; i < strings.size(); i++) {
				String s = strings.get(i);
				if (s.contains("e")) {
					System.out.println(s);
				}
			}
	}
}
