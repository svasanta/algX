package com.san.neXt.alg;

import java.util.Stack;

/**
 * Created by vasantas on 9/20/2016.
 */
public class LeftParenthesesLess {
    private Stack<String> stack = new Stack<>();
    public static void main(String[] args) {
        LeftParenthesesLess l = new LeftParenthesesLess();
        String s = l.correct("1+2)*3-4)*5-6)))*7-9)");
        System.out.println(s);
    }

    private String correct(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')'){
                String last = stack.pop();
                String mid = stack.pop();
                String first = stack.pop();
                stack.push("(" + first+ mid + last + ')');
                System.out.println(stack);
            }else {
                stack.push(ch+"");
            }
        }
        StringBuilder b = new StringBuilder();
        while (! stack.empty()){
            b.insert(0,stack.pop());
        }
        return b.toString();
    }
}
