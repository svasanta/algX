package com.san.neXt.alg;

import java.util.Stack;

/**
 * Created by vasantas on 9/20/2016.
 */
public class Parentheses {
    private Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Parentheses p = new Parentheses();
        p.validate("{()([{}])}[])");
    }

    private void validate(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    char other = stack.pop();
                    if(match(ch, other) ){
                        break;
                    }else {
                        throw new IllegalArgumentException("not well formatted at " + i + ch);
                    }
            }
        }
    }

    private boolean match(char ch, char other) {
        switch (ch){
            case '(':
                return other == ')';
            case ')':
                return other == '(';
            case '[':
                return other == ']';
            case ']':
                return other == '[';
            case '{':
                return other == '}';
            case '}':
                return other == '{';
        }
        return false;
    }
}
