package com.san.neXt.alg;

/**
 * Created by vasantas on 9/20/2016.
 */
public class Queue<T> {
    private T[] array;
    private int f =-1, r =-1;
    private int size =0;

    public Queue(int capacity){
        array = (T[]) new Object[capacity];
    }

    public T pop(){
        if( isEmpty() ){
            throw new IllegalStateException("under flow");
        }

        f = f +1 == array.length ? 0 : f+1;
        T t = array[f];
        array[f] = null;
        size--;
        return t;
    }

    public void push(T t){
        if( isFull() ){
            throw new IllegalStateException("over flow");
        }
        size++;
        //This is required.
        r = (r +1 == array.length ? 0 : r+1);
        array[r] = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
