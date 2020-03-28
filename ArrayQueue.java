public class ArrayQueue<T> implements Queue<T> {

    private Class<T> type;
    private int front;
    private int back;
    private T[] arr;
    private int sz;

    public ArrayQueue() {
        front = sz = 0;
        back = -1;
        arr = (T[]) new Object[10];
    }

    public T dequeue() throws Exception {
        /* case: arr empty to begin with */
        if(empty()){
            throw new Exception("Queue is empty.");
        }

        sz--;
        T ret = arr[front % arr.length];
        front++;

        return ret;
    }

    public void enqueue(T item) {
        sz++;
        /* if the arr is full */
        if(sz == arr.length){
            grow();
            arr[++back] = item;
        } else {
            arr[++back % arr.length] = item;
        }
    }

    public boolean empty() {
        return sz == 0;
    }

    private void grow() {

        T[] new_list;
        new_list = (T[]) new Object[arr.length * 2];

        for (int i = 0; i < sz; i++) {
            new_list[i] = arr[i];
        }
        arr = new_list;

    }
}