import java.util.ArrayList;

public class Queue<T> {


    private ArrayList<T> elements = new ArrayList<>();
    private int n=0;

    Queue() {
    }

    public String toString() {
        return ""+elements ;
    }

    public T print(Integer x){
        return elements.get(x);
    }

    public void dequeue(int x) {
        elements.remove(x);
        n--;
    }

    public void enqueue(T item) {
        elements.add(item);
        n++;
    }

    public void enqueueIndex(T item, int index){
        elements.add(index,item);
        n++;
    }

    public int size() {
        return n;
    }

    public Boolean isEmpty() {
        return (size() == 0);
    }



}
