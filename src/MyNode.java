public class MyNode<T> {
    public T value;
    private T data;
    public MyNode<T> next;
    public MyNode<T> prev;

    public MyNode(T value) {
        this.value = value;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(MyNode<T> prev) {
        this.prev = prev;
    }
}
