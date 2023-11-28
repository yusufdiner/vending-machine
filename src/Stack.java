import java.util.ArrayList;

public class Stack<T> {
    @Override
    public String toString() {
        return ""+elements ;
    }

    private ArrayList<T> elements = new ArrayList<>();

    public T print(Integer x){
        return elements.get(elements.size()-1-x);
    }

    public void pop() {

        elements.remove(elements.size() - 1);

    }

    public void push(T element) {
        elements.add(element);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}