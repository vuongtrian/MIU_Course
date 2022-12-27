package Assignment_Lession_10;

interface StackInterface {
    // push - pop - peek - isEmpty - size

    public void push (Object item);

    public Object pop();

    public Object peek();

    public boolean isEmpty();

    public int size();
}

public class Stack implements StackInterface {
    private Object[] arr;
    private int top;

    public Stack(int n) {
        arr = new Object[n];
        top = -1;
    }

    /*
    * Support method
    * - isEmpty()
    * - size()
    * */
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void push(Object item) {
        if(top == arr.length -1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = item;
    }

    @Override
    public Object pop() {
        if(isEmpty()) {
            return null;
        }
        Object removeObject = arr[top];
        top--;
        return removeObject;
    }

    @Override
    public Object peek() {
        if(isEmpty()) {
            return null;
        }
        return arr[top];
    }


}
