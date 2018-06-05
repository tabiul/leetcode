package leetcode;

import java.util.Stack;

public class Problem844 {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for(char c : S.toCharArray()) {
            if(c == '#') {
                if(!stackS.isEmpty()) stackS.pop();
            } else {
                stackS.push(c);
            }
        }

        StringBuilder stringBuilderS = new StringBuilder();
        while(!stackS.isEmpty()) stringBuilderS.append(stackS.pop());

        for(char c : T.toCharArray()) {
            if(c == '#') {
                if(!stackT.isEmpty()) stackT.pop();
            } else {
                stackT.push(c);
            }
        }

        StringBuilder stringBuilderT = new StringBuilder();
        while(!stackT.isEmpty()) stringBuilderT.append(stackT.pop());

        return stringBuilderS.toString().equals(stringBuilderT.toString());
    }

    public static void main(String[] args) {
        Problem844 problem844 = new Problem844();
        System.out.println(problem844.backspaceCompare("a##c", "#a#c"));
        System.out.println(problem844.backspaceCompare("a#c", "b"));
    }
}
