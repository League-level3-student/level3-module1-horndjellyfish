package _03_IntroToStacks;

import javax.swing.*;
import java.util.Random;
import java.util.Stack;

public class _01_IntroToStack {
    public static void main(String[] args) {
        //1. Create a Stack of Doubles
        //   Don't forget to import the Stack class
        Stack<Double> doubles = new Stack<Double>();
        //2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
        Random rand = new Random(100);
        for (double i = 0; i <= 100; i++) {
            double random = rand.nextDouble() * 100;
           doubles.push(random);

        }

        //3. Ask the user to enter in two numbers between 0 and 100, inclusive.
        String input = JOptionPane.showInputDialog("Enter a number between 0 and 100");
        String input1 = JOptionPane.showInputDialog("Enter a number between 0 and 100 that is larger than the number you previously entered");
        //4. Pop all the elements off of the Stack. Every time a double is popped that is
        //   between the two numbers entered by the user, print it to the screen.
        System.out.println("Popping all the elements off the stack...");
        int sz = doubles.size();
        double minDouble = Double.parseDouble(input);
        double maxDouble = Double.parseDouble(input1);
        System.out.println("Elements between " + minDouble + " and " + maxDouble + ":");
        for (int i = 0; i < sz; i++) {
            Double popped = doubles.pop();

            if ((popped >= minDouble) && (popped <= maxDouble)) {
                System.out.println(popped.doubleValue());
            }
        }


        //   EXAMPLE:
        //   NUM 1: 65
        //   NUM 2: 75

        //   Popping elements off stack...
        //   Elements between 65 and 75:
        //   66.66876846
        //   74.51651681
        //   70.05110654
        //   69.21350456
        //   71.54506465
        //   66.47984807
        //   74.12121224
    }
}
