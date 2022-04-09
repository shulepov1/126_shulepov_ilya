import org.junit.Assert;
import org.junit.Test;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void quickSort_LeftMoreThanRight_QuickSortOK(){
        Integer[] data = {4,1};
        QuickSort<Integer> qSort= new QuickSort<>();
        qSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,4}, data);
    }
    @Test
    public void quickSort_DecreasingArray_QuickSortOK(){
        Integer[] data = {7,6,5,4,3};
        QuickSort<Integer> qSort= new QuickSort<>();
        qSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {3,4,5,6,7}, data);
    }
    @Test
    public void quickSort_RandomTests_QuickSortOK(){
        Integer[] data1 = {15, -45, 32, 999};
        Integer[] data2 = {1};
        Integer[] data3 = {1,1,1,1};
        QuickSort<Integer> qSort= new QuickSort<>();
        qSort.sort(data1, new TestComparator());
        qSort.sort(data2, new TestComparator());
        qSort.sort(data3, new TestComparator());
        assertArrayEquals(new Integer[] {-45, 15, 32, 999}, data1);
        assertArrayEquals(new Integer[] {1}, data2);
        assertArrayEquals(new Integer[] {1,1,1,1}, data3);
    }
    @Test
    public void mergeSort_LeftMoreThanRight_MergeSortOK(){
        Integer[] data = {4,1};
        MergeSort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,4}, data);
    }
    @Test
    public void mergeSort_FirstInTheEnd_MergeSortOK(){
        Integer[] data = {5,6,2};
        MergeSort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,5,6}, data);
    }
    @Test
    public void mergeSort_FirstInTheMiddle_MergeSortOK(){
        Integer[] data = {5,2,6};
        MergeSort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,5,6}, data);
    }
    @Test
    public void mergeSort_RandomArrayWithRepeatingData_MergeSortOK(){
        Integer[] data = {2,0,4,6,8,0,10};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {0,0,2,4,6,8,10}, data);
    }
    @Test
    public void heapSort_LeftMoreThanRight_HeapSortOK(){
        Integer[] data = {4,1};
        HeapSort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,4}, data);
    }
    @Test
    public void heapSort_TwoSortedElements_HeapSortOK(){
        Integer[] data = {1,4};
        HeapSort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,4}, data);
    }
    @Test
    public void heapSort_FirstInTheMiddle_HeapSortOK(){
        Integer[] data = {5,2,6};
        HeapSort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,5,6}, data);
    }
    @Test
    public void heapSort_FourRandomElements_HeapSortOK(){
        Integer[] data = {3,2,5,4};
        HeapSort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,3,4,5}, data);
    }
    @Test
    public void heapSort_HasRepeatingElement_HeapSortOK(){
        Integer[] data = {7,7,8,29,21,44};
        HeapSort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {7,7,8,21,29,44}, data);
    }
    @Test
    public void heapSort_DecreasingArrayLastLastElementIsOk_HeapSortOK(){
        Integer[] data = {9,8,7,6,5,10};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {5,6,7,8,9,10}, data);
    }
    @Test
    public void heapSort_DifficultData_HeapSortOK(){
        Integer[] data = {0,0,0,3,4,4,-421,22,1009,14};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {-421,0,0,0,3,4,4,14,22,1009}, data);
    }
}
