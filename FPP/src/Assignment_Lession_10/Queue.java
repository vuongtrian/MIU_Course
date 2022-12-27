package Assignment_Lession_10;

public class Queue {
    class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;
    int count;

    Queue() {
        front = rear = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int size() {
        return count;
    }

    public void insert(Object item) {
        Node newNode = new Node(item);

        if(front == null) {
            front = rear = newNode;
            front.next = null;
        }
        if(front == rear) {
            rear = newNode;
            front.next = rear;
            rear.next = null;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = null;
        }
        count++;
    }

    public Object remove() {
        if(isEmpty()) {
            return null;
        }
        Object removeIten = front.data;
        front = front.next;
        count--;
        return removeIten;
    }

    public Object peek() {
        return front.data;
    }

    public void display() {
        Node p = front;
        if(p == null) {
            System.out.println("Empty");
        }
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.display();
        q.insert('A');
        q.insert('B');
        q.insert('C');
        q.insert('D');
        q.display();
        System.out.println("Remove(): " + q.remove());
        q.display();
        System.out.println("peek(): " + q.peek());
        q.insert('E');
        q.insert('F');
        System.out.println("Remove(): " + q.remove());
        q.display();
        System.out.println("size(): " + q.size());
        System.out.println("isEmpty(): " + q.isEmpty());
        Queue q1 = new Queue();
        System.out.println("isEmpty(): " + q1.isEmpty());
    }
}
