class Stack<T> {
    T[] arr;
    int size = 0;
    int top = -1;

    Stack(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
    }

    public void push(T element) {
        if (top == size) {
            // queue is full
            System.out.println("Queue is full");
            return;
        }

        arr[++top] = element;
    }

    public T pop() {
        if (top == -1) {
            // queue is empty
            System.out.println("Queue is empty");
            return null;
        }

        int index = top;

        return arr[index--];
    }

    public void display() {
        int index = top;
        while (index != -1) {
            System.out.println(arr[index--]);
        }
    }

    public T peek() { return arr[top]; }

    public void search(T data) {

    }
}

public class CusStack {
    public static void main(String args[]) {
        // Stack<Integer> stack = new Stack<Integer>(10);
        // stack.push(10);
        // stack.push(20);
        // stack.push(30);
        // stack.push(40);

        Stack<String> stack = new Stack<>(10);
        stack.push("Nikunj");
        stack.push("Patel");
        stack.push("Motadata");

        stack.display();

        System.out.println("\nPeek element: "+stack.peek());
    }
}