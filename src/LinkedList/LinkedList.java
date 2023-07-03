package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

//        @Override
//        public String toString() {
//            return value + " -> " + next;
//        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {
        var node = new Node(item);
        if (first == null) {
            first = last = node;
            return;
        }
        node.next = first;
        first = node;
        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (first == null) {
            first = last = node;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public int indexOf(int item) {
        var current = first;
        int index = 0;
        while (current != null) {
            if (current.value == item)
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public void removeFirst() {
        if (first == null)
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (first == null)
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;

        else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while(current != null) {
            if (current.next == node) return current ;
            current = current.next;
        }

        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void print() {
        System.out.println(first);
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        var current = first;
        var index = 0;
        while(index < size) {
            arr[index++] = current.value;
            current = current.next;
        }

        return arr;
    }
}
