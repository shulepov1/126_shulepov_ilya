package task;

public class DoubleLinkedListSorter {

    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        for(int i = 0; i < list.getSize(); i++) {

            DoubleLinkedListItem<T> min =  list.getFirst();
            DoubleLinkedListItem<T> current = list.getFirst();

            for(int j = 0; j < list.getSize() - i; j++) {
                if(current.getData().compareTo(min.getData()) < 0){
                    min = current;
                }
                current = current.getNext();
            }

            list.remove(min);
            list.insertAfter(list.getLast(), (T)min.getData());
        }

    }
}
