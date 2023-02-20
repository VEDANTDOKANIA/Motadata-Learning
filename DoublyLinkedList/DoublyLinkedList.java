class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    Node() {}
    Node(T data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DoublyLinkedList<T> {
    Node<T> head = null;

    public void addFirst(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        
        Node node = head;

        head = new Node(data);
        head.next = node;
        node.prev = head;
    }

    public void addLast(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node node = head;

        while (node.next != null) {
            node = node.next;
        }

        node.next = new Node(data);
        node.next.prev = node;
    }

    public void remove(T data) {
        if (head.data == data) {
            head = head.next;
            head.prev = null;
            return;
        }

        Node node = head;
        Node prev = null;

        while (node != null) {
            if (node.data == data) {
                prev.next = node.next;
                node = node.next;
                node.prev = prev;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public void removeAll(T data) {
        while (head != null && head.next != null && head.data == data) {
            head.prev = null;
            head = head.next;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == data) {
                current.prev = null;
                prev.next = current.next;
                current = current.next;
                if (current != null) {
                    current.prev = prev;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    public void display() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(30);

        list.removeAll(20);

        list.display();
    }
}