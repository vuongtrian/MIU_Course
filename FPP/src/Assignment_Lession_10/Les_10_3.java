package Assignment_Lession_10;

public class Les_10_3 {
    public static void main(String[] args) {
        MyStringDLinkedList dList = new MyStringDLinkedList();
        dList.addFirst("Jack");
        dList.addFirst("Messi");
        dList.addFirst("Ronaldo");
        dList.displayNodes();
        dList.remove("Messi");
        dList.displayNodes();
    }
}

class MyStringDLinkedList {
    Node header;

    MyStringDLinkedList() {
        header = new Node(null, null, null);
    }

    public void addFirst(String item) {
        if(item == null) {
            return;
        }
        Node n = new Node(header, item, header.next);
        if (header.next != null) {
            header.next.previous = n;
        }
        header.next = n;
    }

    public int find(String s) {
        if (s == null) {
            return -1;
        }

        Node currentNode = header;
        int i = -1;
        while (currentNode.next != null) {
            ++i;
            currentNode = currentNode.next;
            if (s.equals(currentNode.value)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        int count = 0;
        Node current = header.next;
        while (current != null) {
            ++count;
            current = current.next;
        }
        return count;
    }

    private Node getNode(int pos) {
        if (pos > size() || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node current = header;
        for (int i = 0; i <= pos; i++) {
            current = current.next;
        }
        return current;
    }

    public String get(int pos) {
        Node node = getNode(pos);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    public void insert(String s, int pos) {
        if(pos > size() || pos < 0) {
            throw new IndexOutOfBoundsException("pos = " + pos + " but size = " + size());
        }
        Node current = header;
        Node previous = null;
        for (int i = 0; i <= pos; i++) {
            if(i == pos) {
                previous = current;
            }
            current = current.next;
        }
        Node insertNode = new Node(previous, s, current);
        if(current != null) {
            current.previous = insertNode;
        }
        previous.next = insertNode;
    }

    public boolean isEmpty() {
        if(header.next == null || size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int index) {
        Node toBeRemove = getNode(index);
        if (toBeRemove == null) {
            return false;
        }
        Node previous = toBeRemove.previous;
        Node next = toBeRemove.next;
        previous.next = next;
        if(next != null) {
            next.previous = previous;
        }
        toBeRemove = null;
        return true;
    }

    public boolean remove (String s) {
        int pos = find(s);
        if(pos == -1) {
            return false;
        }
        return remove(pos);
    }

    public void displayNodes() {
        Node current = header.next;
        while (current.next != null) {
            System.out.print(current.value + "--> ");
            current = current.next;
        }
        System.out.println(current.value);
    }
}

class Node {
    Node previous;
    String value;
    Node next;

    Node(Node previous, String value, Node next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }
}
