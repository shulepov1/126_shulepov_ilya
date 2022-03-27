import org.junit.Assert;
import org.junit.Test;

public class Task2_Tests extends Assert {
    static class TestComparator implements MyComparator<Integer> {

        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    /*
    for BubbleSort:
     */
    @Test
    public void BubbleSort_sortOneElement_sortOK() {
        Integer[] data = {1};
        BubbleSort<Integer> bs = new BubbleSort<Integer>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1}, data);
    }

    @Test
    public void BubbleSort_sortSortedArray_sortOK() {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7};
        BubbleSort<Integer> bs = new BubbleSort<Integer>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, data);
    }

    @Test
    public void BubbleSort_sortRandomInts_sortOK() {
        Integer[] data = {100, 282, 15, 145, 19999};
        BubbleSort<Integer> bs = new BubbleSort<Integer>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{15, 100, 145, 282, 19999}, data);
    }

    @Test
    public void BubbleSort_sortFirstElementIsSorted_sortOK() {
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 12, 9};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 9, 12}, data);
    }

    /*
    for SelectionSort:
     */
    @Test
    public void SelectionSort_sortOneElement_sortOK() {
        Integer[] data = {1};
        Sort<Integer> bs = new SelectionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1}, data);
    }

    @Test
    public void SelectionSort_sortSortedArray_sortOK() {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7};
        Sort<Integer> bs = new SelectionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, data);
    }

    @Test
    public void SelectionSort_sortRandomInts_sortOK() {
        Integer[] data = {100, 282, 15, 145, 19999};
        Sort<Integer> bs = new SelectionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{15, 100, 145, 282, 19999}, data);
    }

    @Test
    public void SelectionSort_sortFirstElementIsSorted_sortOK() {
        Sort<Integer> bs = new SelectionSort<>();
        Integer[] data = {1, 12, 9};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 9, 12}, data);
    }

    /*
    for InsertionSort:
     */
    @Test
    public void InsertionSort_sortOneElement_sortOK() {
        Integer[] data = {1};
        Sort<Integer> bs = new InsertionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1}, data);
    }

    @Test
    public void InsertionSort_sortSortedArray_sortOK() {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7};
        Sort<Integer> bs = new InsertionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, data);
    }

    @Test
    public void InsertionSort_sortRandomInts_sortOK() {
        Integer[] data = {100, 282, 15, 145, 19999};
        Sort<Integer> bs = new InsertionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{15, 100, 145, 282, 19999}, data);
    }

    @Test
    public void InsertionSort_sortFirstElementIsSorted_sortOK() {
        Sort<Integer> bs = new InsertionSort<>();
        Integer[] data = {1, 12, 9};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 9, 12}, data);
    }
}
