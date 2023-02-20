package org.example.DataStructure.LinkedList;

class Node <T>{
    private T data;
    private Node next;

    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() { return this.next; }

    public void setNext(Node<T> node) { this.next = node; }

    public Node<T> get() { return this; }
}

public class LinkedList<T> {
    Node<T> head = null;

    LinkedList() {}
    LinkedList(LinkedList<T> list) {
        head = list.head;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
            return;
        }
        Node<T> tem = head;

        while (tem.getNext() != null) {
            tem = tem.getNext();
        }

        tem.setNext(new Node<T>(data));
    }

    public void addFirst(T data) {
        Node<T> node = head;
        head = new Node<T>(data);
        head.setNext(node);
    }

    public void removeAll(T data) {

        while (head != null && head.getNext() != null && head.getData() == data) {
            head = head.getNext();
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null ) {
            if (current.getData() == data) {
                prev.setNext(current.getNext());
                current = current.getNext();

                continue;
            }

            prev = current;
            current = current.getNext();
        }
    }

    public void remove(T data) {
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() == data) {
                prev.setNext(current.getNext());
                return;
            }

            prev = current;
            current = current.getNext();
        }
    }

    public void clear() {
        head = null;
        return;
    }

    public void display() {
        Node<T> node = head;
        
        while (node != null) {
            System.out.print(node.getData()+" ");
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> head = new LinkedList<>();
        head.add(10);
        head.add(30);
        head.add(40);
        head.add(40);
        head.addFirst(15);

        head.removeAll(40);
        head.remove(30);

        LinkedList<Integer> newList = new LinkedList<>(head);

        newList.display();

        System.out.println(head);
    }
}