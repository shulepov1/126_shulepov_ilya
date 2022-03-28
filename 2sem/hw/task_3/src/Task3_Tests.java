import org.junit.Assert;
import org.junit.Test;

public class Task3_Tests extends Assert {
    MyComparator<Integer> comparator = new MyComparator<Integer>() {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    };
    @Test
    public void QuickSort_sortTwoElements_SortOK(){
        Integer[] arr = {2, 1};
        Sort<Integer> qs = new QuickSort<>();
        qs.sort(arr, comparator);
        assertArrayEquals(new Integer[]{1,2}, arr);
    }
    @Test
    public void QuickSort_sortSomeData_SortOK(){
        Integer[] arr = {19, 43, -20, 0, 1, 120};
        Sort<Integer> qs = new QuickSort<>();
        qs.sort(arr, comparator);
        assertArrayEquals(new Integer[]{-20, 0, 1, 19, 43, 120}, arr);
    }
    @Test
    public void MergeSort_sortTwoElements_SortOK(){
        Integer[] arr = {2, 1};
        Sort<Integer> ms = new MergeSort<>();
        ms.sort(arr, comparator);
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }
    @Test
    public void MergeSort_sortSortedArray7Elements_SortOK(){
        Integer[] arr = {2, 1, 4, 5, 3, 7 ,6};
        Sort<Integer> ms = new MergeSort<>();
        ms.sort(arr, comparator);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6,7}, arr);
    }
    @Test
    public void HeapSort_sortTwoElements_sortOK(){
        Integer[] arr = {2,0};
        Sort<Integer> hs = new HeapSort<>();
        hs.sort(arr, comparator);
        assertArrayEquals(new Integer[]{0,2}, arr);
    }
    @Test
    public void HeapSort_sortTwoSortedElements_sortOK(){
        Integer[] arr = {0,2};
        Sort<Integer> hs = new HeapSort<>();
        hs.sort(arr, comparator);
        assertArrayEquals(new Integer[]{0,2}, arr);
    }
    @Test
    public void HeapSort_sortBigSortedArray_sortOK(){
        Integer[] arr = {4,5,6,7,8,9,10,12,15,18,200};
        Sort<Integer> hs = new HeapSort<>();
        hs.sort(arr, comparator);
        assertArrayEquals(new Integer[]{4,5,6,7,8,9,10,12,15,18,200}, arr);
    }
}
