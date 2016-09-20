package com.san.neXt.alg;

import java.util.Stack;

/**
 * Created by vasantas on 9/20/2016.
 */
public class InfixToPostfix {
    private Stack<String> stack = new Stack<>();
    public static void main(String[] args) {
        InfixToPostfix i = new InfixToPostfix();
        System.out.println(i.convert("((1+2)-5)"));
        System.out.println(i.convert("(1+(2-5))"));
        System.out.println(i.convert("1+(2-5)"));
        System.out.println(i.convert("1*2-5"));
    }

    public String convert(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case ')':
                    String last = stack.pop();
                    String mid = stack.pop();
                    String first = stack.pop();
                    stack.push(first+ last + mid );
                    break;
                case '(':
                    //Ignore
                    break;
                default:
                    stack.push(ch+"");
            }
        }
        while (stack.size() > 1){
            String last = stack.pop();
            String mid = stack.pop();
            String first = stack.pop();
            stack.push(first+ last + mid );
        }
        return stack.pop();
    }
}
