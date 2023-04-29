package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    20. Valid Parentheses
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
    
    Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false

    Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
*/
public class Twenty {
    
    public static void main (String[] args) {
        // case 1
        String s = "()";
        // case 2
        // String s = "()[]{}";
        // case 3
        // String s = "(]";
        // case 4
        // String s = "(";
        // case 5
        // String s = "{[]}";
        // ans : true
        // case 6
        // String s = "(([]){})";
        // case 7
        // String s = "([}}])";
        // case 8
        // String s = "([)]";
        
        System.out.println("isValid : " + isValid(s));
        System.out.println("isValidWay2 : " + isValidWay2(s));
    }

    private static boolean isValid(String s) {
        if (s.length()%2 != 0) {
            return false;
        }
        Stack<Character> stackCharacter = new Stack<>();
        for (char sChar : s.toCharArray()) {
            if (sChar == '(' || sChar == '[' || sChar == '{') {
                stackCharacter.push(sChar);
            } else {
                if (stackCharacter.empty()) {
                    return false;
                }
                if (sChar == ')' && stackCharacter.peek() == '(') {
                    stackCharacter.pop();
                } else if (sChar == ']' && stackCharacter.peek() == '[') {
                    stackCharacter.pop();
                } else if (sChar == '}' && stackCharacter.peek() == '{') {
                    stackCharacter.pop();
                } else {
                    return false;
                }
            }
        }
        return stackCharacter.empty();
    }

    private static boolean isValidWay2 (String s) {
        List<Character> listChar = new ArrayList<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    listChar.add(c);
                    break;
                default:
                    int index = listChar.size() - 1 >= 0 ? listChar.size() - 1 : -1;
                    if (index == -1) {
                        return false;
                    }
                    if (c == ')' && listChar.get(index) == '(') {
                        listChar.remove(index);
                    } else if (c == ']' && listChar.get(index) == '[') {
                        listChar.remove(index);
                    } else if (c == '}' && listChar.get(index) == '{') {
                        listChar.remove(index);
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return listChar.isEmpty();
    }
}
