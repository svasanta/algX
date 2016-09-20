package com.san.neXt.alg;

import java.util.Stack;

/**
 * Created by vasantas on 9/20/2016.
 */
public class Evaluate {
    private Stack<Integer> operands = new Stack<>();
    private Stack<Character> oper = new Stack<>();

    public static void main(String[] args) {
        Evaluate e = new Evaluate();
        System.out.println( e.evaluate("(3+(4*5))") );
        System.out.println( e.evaluate("((3+4)*5)") );
    }

    //For simplicity assume all number are single digit
    private int evaluate(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                operands.add(Character.getNumericValue(ch));
                System.out.println(operands);
            }else if(ch == '('){
                continue;
            }else if (ch == ')'){
                Character o = oper.pop();
                int val = evaluate(o, operands.pop(), operands.pop());
                operands.push(val);
            }else {
                oper.push(ch);
            }
        }
        return operands.pop();
    }

    private int evaluate(Character o, Integer pop, Integer pop1) {
        switch (o){
            case '+':
                return pop + pop1;
            case '-':
                return pop - pop1;
            case '*':
                return pop * pop1;
            case '/':
                return pop / pop1;
            default:
                throw new UnsupportedOperationException(o +"");
        }
    }
}
