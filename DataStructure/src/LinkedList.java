import java.util.StringJoiner;

/**
 * This is the implementation of the linked list
 */
public class LinkedList implements AbstractList {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int size() {
        return this.length;
    }

    public void insert(int x) {
        Node current = new Node(x);
        if (this.length == 0) {
            this.head = current;
            this.tail = current;
            this.length = 1;
            return;
        }
        this.tail.next = current;
        this.tail = current;
        this.length += 1;
    }

    public int get(int index) {
        if (index >= this.length) {
            throw new RuntimeException("Index exceeds the upper limit of the linked list");
        }
        Node pointer = this.head;
        while (index > 0) {
            pointer = pointer.next;
            index--;
        }
        return pointer.value;
    }

    public int remove(int index) {
        if (index >= this.length) {
            throw new RuntimeException("Index exceeds the upper limit of the linked list");
        }
        if (index == 0) {
            // Remove first element
            int temp = this.head.value;
            this.head = this.head.next;
            this.length--;
            return temp;
        }
        Node pointer = this.head;
        if (index == this.length-1) {
            // Remove last element
            int temp = this.tail.value;
            while (pointer.next != this.tail) {
                pointer = pointer.next;
            }
            pointer.next = null;
            this.tail = pointer;
            this.length--;
            return temp;
        }
        // Remove something in the middle
        while (index > 1) {
            pointer = pointer.next;
            index--;
        }
        int temp = pointer.next.value;
        pointer.next = pointer.next.next;
        this.length--;
        return temp;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean empty() {
        return this.length == 0;
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (Node current = this.head; current != null; current = current.next) {
            sj.add(Integer.toString(current.value));
        }
        return sj.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LinkedList other = (LinkedList) obj;
        if (this.length != other.size()) {
            return false;
        }
        for (int i = 0; i < this.length; i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        for (Node current = this.head; current != null; current = current.next) {
            result = prime * result + current.value;
        }
        return result;
    }

}
