package Assignment_Lession_13;

import java.util.LinkedList;

interface LinkedListStack {
    public void push (Object item);

    public Object pop();

    public Object peek();

    public boolean isEmpty();

    public int size();
}

public class LinkedListStackImpl implements LinkedListStack {
     private Node top = null;
     private int count = 0;

    @Override
    public void push(Object item) {
        Node newNode = new Node(item);
        if(isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        count++;
    }

    @Override
    public Object pop() {
        if(isEmpty()) {
            System.out.println("Empty");
            return null;
        }
        Node removeNode = top;
        top = top.next;
        count--;
        return removeNode.value;
    }

    @Override
    public Object peek() {
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    public void display() {
        int i = 0;
        Node curNode = top;
        while (i < count) {
            System.out.print(curNode.value + "->");
            curNode = curNode.next;
            i++;
        }
        System.out.println();
    }

    class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListStackImpl list = new LinkedListStackImpl();
        list.push(24);
        list.push(51);
        list.display();
        System.out.println("Peek: " + list.peek());
        list.pop();
        list.pop();
        list.pop();
    }
}
