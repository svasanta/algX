package com.san.neXt.alg;

/**
 * Created by vasantas on 9/20/2016.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("This is fine...");
        Queue<Integer> q = new Queue<>(16);
        for(int i=100; i < 115; i++){
            q.push(i);
            q.push(i + 200);
            System.out.println(q.pop());
        }

        while (! q.isEmpty()){
            System.out.println(q.pop());
        }

    }

}
