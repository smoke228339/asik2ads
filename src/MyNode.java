public class MyNode<T> {
    public T value;
    public MyNode<T> next;
    public MyNode<T> prev;

    public MyNode(T value) {
        this.value = value;
    }
}
