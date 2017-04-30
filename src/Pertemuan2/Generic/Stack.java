package Pertemuan2.Generic;

import java.lang.reflect.Array;

/**
 * Created by matt on 3/22/17.
 */
public class Stack<V extends Number> {
    private int size, pointer;
    private V[] container;

    public Stack(Class<V> className) {
        this(className, null);
    }

    public Stack(Class<V> className, Integer size) {
        if (size == null)
            this.size = 10;
//        container = (V[]) Array.newInstance(className, this.size);
//        container = new V[10];
        pointer = -1;
    }

    public <T extends Number> void push(T item) throws OutOfLimitException {
        if (pointer + 1 >= size)
            throw new OutOfLimitException();
        this.container[++pointer] = (V) item;
    }

    public <T extends Number> T pop() throws OutOfLimitException {
        if (this.pointer >= 0)
            return (T) this.container[pointer--];
        throw new OutOfLimitException();
    }

    public static class OutOfLimitException extends Exception {

    }
//
//    public void tambah(V a, V b) {
//        V d = a + b;
//    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(Integer.class, 10);
        try {
            stack.push(12);
            stack.pop();
        } catch (OutOfLimitException e) {
            e.printStackTrace();
        }
    }
}

//class OutOfLimitException extends Exception {
//
//}
