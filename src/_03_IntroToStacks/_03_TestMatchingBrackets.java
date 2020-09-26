package _03_IntroToStacks;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _03_TestMatchingBrackets {

    @Test
    public void testMatchingBrackets() {
        assertTrue(doBracketsMatch("{}"));
        assertTrue(doBracketsMatch("{{}}"));
        assertTrue(doBracketsMatch("{}{}{{}}"));
        assertFalse(doBracketsMatch("{{}"));
        assertFalse(doBracketsMatch("}{"));
    }

    // USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
    private boolean doBracketsMatch(String brackets) {
        Stack<Character> stack = new Stack<Character>();
        //1. Use a for loop to iterate through your brackets String
        char[] chars = brackets.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (current == '{') {
                stack.push(current);
            } else if (current == '}') {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }

        }
        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
        //2.  If the current character is an '{'

        //3.  Push an '{' onto the stack

        //4.  else if the character is a '}'

        //6.  if the stack is empty (i.e. there is no matching opening bracket)

        //7.  return false

        //5.  Pop a character from the stack


        //8.  if the stack is not empty (i.e. there were too many opening brackets)

        //9. return false

        //10. else (i.e. everything matched correctly)

        //11. return true


    }

}
