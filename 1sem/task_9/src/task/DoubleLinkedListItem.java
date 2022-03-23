package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {
    private DoubleLinkedListItem<T> next;
    private DoubleLinkedListItem<T> prev;
    private T data;

    public DoubleLinkedListItem(T data) {
     this.data = data;
    }
    public DoubleLinkedListItem<T> getNext() {
        return next;
    }
    public DoubleLinkedListItem<T> getPrev() {
        return prev;
    }
    public T getData() {
        return data;
    }
    public void setNext(DoubleLinkedListItem<T> next) {
        this.next = next;
    }
    public void setPrev(DoubleLinkedListItem<T> prev) {
        this.prev = prev;
    }
    public void setData(T data) {
        this.data = data;
    }
}
