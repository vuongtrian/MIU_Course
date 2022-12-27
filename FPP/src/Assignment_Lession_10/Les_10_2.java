package Assignment_Lession_10;

public class Les_10_2 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Add last");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display();
        System.out.println("Add first");
        list.addFirst(5);
        list.display();
        System.out.println("Add at 2");
        list.addAtIndex(15,2);
        list.display();
        System.out.println("Remove last");
        list.removeLast();
        list.display();
        System.out.println("Remove first");
        list.removeFirst();
        list.display();
        System.out.println("Remove at 1");
        list.removeAtIndex(1);
        list.display();
    }
}

class SinglyLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addLast (int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addFirst (int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAtIndex(int data, int pos) {
        if(pos < 0) {
            return;
        }

        Node newNode = new Node(data);
        if(pos == 0) {
            addFirst(data);
            return;
        }

        Node curNode = head;
        Node preNode = null;
        int index = 0;

        while (index < pos) {
            preNode = curNode;
            curNode = curNode.next;
            index++;
        }
        preNode.next = newNode;
        newNode.next = curNode;
    }

    public boolean removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return true;
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        return true;
    }

    public boolean removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return true;
        }
        Node temp = head;
        head = head.next;
        temp = null;
        return true;
    }

    public boolean removeAtIndex(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        if(pos < 0) {
            return false;
        }
        if(pos == 0) {
            return removeFirst();
        }

        int index = 0;
        Node curNode = head;
        Node preNode = null;
        while (index < pos) {
            preNode = curNode;
            curNode = curNode.next;
            index++;
        }
        preNode.next = curNode.next;
        curNode = null;
        return true;
    }

    public boolean find (int n) {
        if(head == null) {
            return false;
        }

        Node current = head;
        while (current != null) {
            if(current.data == n) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current =head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println();
    }


}
