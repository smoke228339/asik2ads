public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> prev = current.getPrev();

            prev.setNext(newNode);
            newNode.setPrev(prev);
            newNode.setNext(current);
            current.setPrev(newNode);

            size++;
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).getData();
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException("Empty list");
        return head.getData();
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException("Empty list");
        return tail.getData();
    }

    @Override
    public void set(int index, T item) {
        getNode(index).setData(item);
    }

    @Override
    public void remove(int index) {
        MyNode<T> node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) return;
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) return;
        removeNode(tail);
    }

    private void removeNode(MyNode<T> node) {
        MyNode<T> prev = node.getPrev();
        MyNode<T> next = node.getNext();

        if (prev != null) prev.setNext(next);
        else head = next;

        if (next != null) next.setPrev(prev);
        else tail = prev;

        size--;
    }

    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.getNext();
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.getPrev();
        }
        return current;
    }

    @Override
    public void sort() {
        if (!(head.getData() instanceof Comparable)) {
            throw new IllegalStateException("Elements are not comparable");
        }

        Object[] arr = toArray();
        java.util.Arrays.sort(arr);
        clear();
        for (Object obj : arr) {
            add((T) obj);
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            if (current.getData().equals(object)) return i;
            current = current.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int i = size - 1;
        while (current != null) {
            if (current.getData().equals(object)) return i;
            current = current.getPrev();
            i--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.getData();
            current = current.getNext();
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private MyNode<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
