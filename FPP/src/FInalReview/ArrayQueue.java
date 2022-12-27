package FInalReview;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear = 0;

    public int peek() {
       if(isEmpty()) {
           throw new NoSuchElementException("Empty list");
       }
       return arr[front];
    }

    public int dequeue() throws NoSuchElementException {
        int deleteValue = arr[front];
        int[] temp = new int[arr.length];
        System.arraycopy(arr,1,temp,0, arr.length-1);
        arr = temp;
        rear--;
        return deleteValue;
    }

    private void resize() {
        int newLen = arr.length * 2;
        int[] temp = new int[newLen];
        System.arraycopy(arr,0, temp, 0, arr.length);
        arr = temp;
    }

    public void enqueue(int obj) {
        if (front == -1) {
            front++;
        }
        if (isFull()) {
            resize();
        }
        arr[rear++] = obj;
    }

    private boolean isFull() {
        return rear == arr.length;
    }

    public boolean isEmpty() {
        return (front == -1 || front >= rear);
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear - front;
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        try {
            q.peek();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        for(int i = 0; i < 15; i++) {
            q.enqueue(i);
        }
        for(int i = 0; i < 14; i++) {
            q.dequeue();
        }
        System.out.println(q.size());
    }
}
