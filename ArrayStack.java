import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{

    private Class<T> type;
    private int top;
    private T[] arr;

    public ArrayStack(){
        top = 0;
        arr = (T[])new Object[10];
    }

    public void push(T item){
        /* we max out the arr thus, we need to grow it */
        if(top == arr.length){
            grow();
        }
        arr[top++] = item;
    }

    public T pop() throws EmptyStackException {
        /* arr is empty and thus, there is nothing to pop */
        if(top == 0){
            throw new EmptyStackException();
        }
        return arr[--top];
    }

    public T peek() throws EmptyStackException{
        if(top == 0){
            throw new EmptyStackException();
        }
        /* we want to return a copy of the last pushed T */
        T ret = arr[top - 1];
        return ret;
    }

    public boolean empty(){
        return top== 0;
    }

    private void grow(){

        T[] new_list;
        new_list = (T[])new Object[arr.length * 2];

        for(int i = 0; i < top; i++){
            new_list[i] = arr[i];
        }
        arr = new_list;

    }

}
