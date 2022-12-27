package FInalReview;

public class MyList {
    Node header;

    public void addFront (Integer item) {
        if(header == null) {
            header = new Node(null,item,null);
        } else {
            Node n = new Node(null, item,header);
            header.previous = n;
            header = n;
        }
    }

    public int sum(Node head) {
        int sum = head.value;
        Node temp = head;
        if(temp.next != null) {
            return sum+= sum(temp.next);
        }
        return sum;
    }

    public void Min() {
        if(header == null) {
            return;
        }
        int min = header.value;
        Node temp = header.next;
        while (temp != null) {
            if(temp.value < min) {
                min = temp.value;
            }
            temp = temp.next;
        }
        System.out.println("Min: " + min);
    }

    public class Node {
        Integer value;
        Node next;
        Node previous;
        Node(Node previous, Integer value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
