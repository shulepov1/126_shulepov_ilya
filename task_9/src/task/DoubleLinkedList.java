package task;

public class DoubleLinkedList<T extends Comparable<T>> {

   private DoubleLinkedListItem<T> first;
   private DoubleLinkedListItem<T> last;
   private int size;

   public DoubleLinkedList(){
       size = 0;
   }

   public DoubleLinkedListItem<T> findFirstItem(T value){
       DoubleLinkedListItem<T> item = first;
       while (item.getData() != value) {
           item = item.getNext();
       }
       return item;
   }
    public DoubleLinkedListItem<T> findLastItem(T value){
        DoubleLinkedListItem<T> item = last;
        while (item.getData() != value) {
            item = item.getPrev();
        }
        return item;
    }
    public void insertAfter(DoubleLinkedListItem<T> item, T value){
        DoubleLinkedListItem<T> newItem = new DoubleLinkedListItem<T>(value);
        if (item == null && size == 0) {
            first = newItem;
            last = newItem;
        }
        else if (item == null && size != 0){
            insertBefore(first, value);
            size--;
        }
        else if (item.getNext() == null){
            item.setNext(newItem);
            newItem.setPrev(item);
            last = newItem;
        }
        else {
            newItem.setNext(item.getNext());
            newItem.setPrev(item);
            item.getNext().setPrev(newItem);
            item.setNext(newItem);
        }
        size++;
    }
    public void insertBefore(DoubleLinkedListItem<T> item, T value) {
        DoubleLinkedListItem<T> newItem = new DoubleLinkedListItem<T>(value);
        if (item == null && size == 0) {
            first = newItem;
            last = newItem;
        }
        else if(item == null && size != 0){
            insertAfter(last, value);
            size--;
        }
        else if (item.getPrev() == null){
            item.setPrev(newItem);
            newItem.setNext(item);
            first = newItem;
        }
        else {
            item.getPrev().setNext(newItem);
            newItem.setPrev(item.getPrev());
            item.setPrev(newItem);
            newItem.setNext(item);
        }
        size++;
    }
    public void remove(DoubleLinkedListItem<T> item) {
       size--;
       if (item.getNext() == null && item.getPrev() == null) {
           first = null;
           last = null;
       }
       else if (item.getNext() == null && item.getPrev() != null) {
           item.getPrev().setNext(null);
           last = item.getPrev();
       }

       else if (item.getNext() != null && item.getPrev() == null) {
           item.getNext().setPrev(null);
           first = item.getNext();
       }
       else if (item.getNext() != null && item.getPrev() != null) {
           item.getPrev().setNext(item.getNext());
           item.getNext().setPrev(item.getPrev());
       }
    }
    public int getSize() {
       return size;
    }
    public DoubleLinkedListItem<T> getFirst(){
       return first;
    }
    public DoubleLinkedListItem<T> getLast(){
        return last;
    }
}
