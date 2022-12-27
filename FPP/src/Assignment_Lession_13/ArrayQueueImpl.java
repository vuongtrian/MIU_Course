package Assignment_Lession_13;

import java.util.Arrays;

interface ArrayQueue {
    public boolean isEmpty();
    public int size();
    public void enqueue(int item);
    public int dequeue();
    public int peek();
}

public class ArrayQueueImpl implements ArrayQueue {
    private int[] arr = new int[3];
    private int front = -1;
    private int rear = 0;

    @Override
    public boolean isEmpty() {
        return (front == -1);
    }

    @Override
    public int size() {
        return (rear-front+1);
    }

    @Override
    public void enqueue(int item) {
        if(rear == arr.length-1) {
            resize();
        }
        if(isEmpty()) {
            front++;
        } else {
            rear++;
        }
        arr[rear] = item;
    }

    @Override
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removeValue = arr[front];
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 1, temp, 0, arr.length-1);
        arr = temp;
        if(rear == 0) {
            front--;
        } else {
            rear--;
        }
        return removeValue;
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public void resize() {
        int newLen = arr.length * 2;
        int[] temp = new int[newLen];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty");
        } else if(rear == front) {
            System.out.println(arr[rear]);
        }
        else {
            for(int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + "->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueueImpl queueArr = new ArrayQueueImpl();
        queueArr.enqueue(4);
        queueArr.enqueue(55);
        queueArr.enqueue(12);
        queueArr.display();
        System.out.println("Size: " + queueArr.size());
        queueArr.enqueue(24);
        queueArr.display();
        System.out.println("Size: " + queueArr.size());
        System.out.println("Peek: " + queueArr.peek());

        System.out.println("Start to dequeue");

        queueArr.dequeue();
        queueArr.display();
        System.out.println("Front: " + queueArr.front + " - Rear: " + queueArr.rear);

        queueArr.dequeue();
        queueArr.display();
        System.out.println("Front: " + queueArr.front + " - Rear: " + queueArr.rear);

        queueArr.dequeue();
        queueArr.display();
        System.out.println("Front: " + queueArr.front + " - Rear: " + queueArr.rear);

        queueArr.dequeue();
        System.out.println(queueArr.isEmpty());
        queueArr.display();
        System.out.println("Front: " + queueArr.front + " - Rear: " + queueArr.rear);
    }
}
