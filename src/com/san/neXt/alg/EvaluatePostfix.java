package com.san.neXt.alg;

import java.util.Stack;

/**
 * Created by vasantas on 9/20/2016.
 */
public class EvaluatePostfix {
    private Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        InfixToPostfix i = new InfixToPostfix();

        EvaluatePostfix e = new EvaluatePostfix();
        System.out.println(e.eval(i.convert("((1+2)*5)+4")));
        System.out.println(e.eval(i.convert("(((1+(2*5))-5)-3)")));
    }

    private Integer eval(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(Character.getNumericValue(ch));
            }else {
                Integer sec = stack.pop();
                Integer first = stack.pop();
                stack.push(evaluate( ch, first, sec) );
            }
        }
        return stack.pop();
    }

    private Integer evaluate(Character o, Integer pop, Integer pop1) {
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