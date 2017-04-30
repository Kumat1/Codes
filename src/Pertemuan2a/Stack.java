package Pertemuan2a;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Created by matt on 3/27/17.
 */
public class Stack<T> {
    public T[] array;
    public int pointer;

    public Stack(Class<?> classname) {
        array = (T[]) Array.newInstance(classname, 10);
        pointer = -1;
    }

    public void push(T item) {
        array[++pointer] = item;
    }

    public T pop() {
        return array[pointer--];
    }

    public static void main(String args[]) {
        Stack<Integer> coba = new Stack<Integer>(Integer.class);
        Scanner scanner = new Scanner(System.in);
        coba.push(scanner.nextInt());
    }
}
