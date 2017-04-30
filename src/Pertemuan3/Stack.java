package Pertemuan3;

/**
 * Created by matt on 3/29/17.
 */
public class Stack {
    public int[] element;

    public int pointer = -1;

    Stack(int size) {
        this.element = new int[size];
    }

    public void push(int item) {
        element[++pointer] = item;
    }

    public int pop() {

        return element[pointer--];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        try {
            stack.pop();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        stack.pop();
        stack.pop();
    }
}
