import java.awt.desktop.PreferencesEvent;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(new Solution().backspaceCompare(s, t));


    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        stack1 = buildStack(s, stack1);
        stack2 = buildStack(t, stack2);

        return stack1.equals(stack2);
    }

    public Stack buildStack(String e, Stack x) {
        for (int i = 0; i < e.length(); i++) {
            char c = e.charAt(i);
            if (!x.isEmpty() && c == '#') x.pop();
            else {
                if (c != '#')
                    x.push(c);
            }
        }
        return x;
    }
}

// brushhing up on String builder first. this doesn't work in leetcode but works here. not sure why
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                a.append(s.charAt(i));
            } else {
                if (a.length() > 0) {
                    a.deleteCharAt(a.length() - 1);
                }
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                b.append(t.charAt(i));
            } else {
                if (b.length() > 0) {
                    b.deleteCharAt(b.length() - 1);
                }
            }
        }
        return a.toString().equals(b.toString());
//        return a.equals(b);
        // .equals can't be used on StringBuilder or objects. compares memory addreess. will always be false
        // .equals will compare data of two Strings, not their addresses, so it works for Strings
        // must comparee conversion
    }
}


//// the problem is not about length. its asking for string comparison
//class Solution {
//    public boolean backspaceCompare(String s, String t) {
//        int sLength = s.length();
//        int tLength = t.length();
//        int sCount = 0;
//        int tCount = 0;
//        for(int i = 0; i<s.length(); i++){
//            if (s.charAt(i) == '#'){
//                sCount+=2;
//            }
//        }
//        System.out.println(s.length());
//        System.out.println(sCount);
//        for(int i = 0; i<t.length(); i++){
//            if (t.charAt(i) == '#'){
//                tCount+=2;
//            }
//        }
//        System.out.println(t.length());
//        System.out.println(tCount);
//        if (sLength - sCount == tLength - tCount){
//            return true;
//        }
//        return false;
//
//    }
//}