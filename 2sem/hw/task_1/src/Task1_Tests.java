import org.junit.Assert;
import org.junit.Test;

public class Task1_Tests extends Assert {
    /*
    Unit Tests for DynamicArray:
     */
    @Test
    public void DynamicArray_CreateArrayWithNoSize_SizeEqualsZero(){
        DynamicArray<Integer> arr = new DynamicArray<>();
        int size = arr.getSize();
        assertEquals(0, size);
    }
    @Test
    public void DynamicArray_CreateArrayWithGivenSize_SizeIsCorrect(){
        DynamicArray<Long> arr1 = new DynamicArray<>(12);
        DynamicArray<Long> arr2 = new DynamicArray<>(5);
        DynamicArray<Long> arr3 = new DynamicArray<>(199);

        assertEquals(12, arr1.getSize());
        assertEquals(5, arr2.getSize());
        assertEquals(199, arr3.getSize());
    }
    @Test
    public void resize_ResizeArray_ResizeIsCorrect(){
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        arr.resize(20);
        assertEquals(20, arr.getSize());
    }
    @Test
    public void resize_ResizeArrToNegative_GetNegativeSizeArrayException(){
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        try{
            arr.resize(-20);
        }
        catch (NegativeArraySizeException e){
            assertEquals("Size can not be negative", e.getMessage());
        }
    }
    @Test
    public void set_setOneItem_SetIsCorrect(){
        DynamicArray<String> arr = new DynamicArray<>(1);
        arr.set(0, "str");
        assertEquals("str", arr.get(0));
    }
    @Test
    public void get_getAnElement_GetIsCorrect(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        assertEquals(3, arr.get(0).intValue());
    }
    @Test
    public void get_getSizeIndex_GetIndexOutOfBoundsException(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        try{
            arr.get(3);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void get_getNegativeIndex_GetIndexOutOfBoundsException(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        try{
            arr.get(-3);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void get_getIndexOutOfBounds_GetIndexOutOfBoundsException(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        try{
            arr.get(15);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void set_setToSizeIndex_GetIndexOutOfBoundsException(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        try{
            arr.set(3, 12);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void set_setIndexOutOfBounds_GetIndexOutOfBoundsException(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        try{
            arr.set(13, 12);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void insert_insertElement_ElementInsertedOK(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        arr.insert(1, 60);
        assertEquals(60, arr.get(1).intValue());
    }
    @Test
    public void pushBack_pushBackValue_PushBackOK(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        arr.pushBack(12);
        assertEquals(12, arr.get(3).intValue());
    }
    @Test
    public void popBack_popBackValue_popBackOK(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        arr.popBack();
        try {
            arr.get(2);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void popBack_popBackInEmptyArray_GetUnsupportedOperationException(){
        DynamicArray<Integer> arr = new DynamicArray<>();
        try {
            arr.popBack();
        }
        catch (UnsupportedOperationException e){
            assertEquals("Array is empty", e.getMessage());
        }
    }
    @Test
    public void remove_removeValueFromArray_removeOK(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        arr.remove(1);
        assertEquals(3, arr.get(0).intValue());
        assertEquals(9, arr.get(1).intValue());
    }
    @Test
    public void remove_removeValueWithSizeIndex_GetIndexOutOfBoundsException(){
        DynamicArray<Integer> arr = new DynamicArray<>(3);
        arr.set(0, 3);
        arr.set(1, 6);
        arr.set(2, 9);
        try{
            arr.remove(1);
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    /*
    Unit Tests for DoubleLinkedList:
     */
    @Test
    public void isEmpty_CreateEmptyDLL_isEmptyTrue(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
    }
    @Test
    public void isEmpty_CreateNotEmptyDLL_isEmptyFalse(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(13);
        assertFalse(list.isEmpty());
    }
    @Test
    public void pushFront_pushFrontValue_pushFrontOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(9);
        list.pushFront(4);
        assertEquals(4, ((Node<Integer>) list.getHead()).getData().intValue());
    }
    @Test
    public void getHead_getHead_getHeadOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(20);
        list.pushFront(12);
        assertEquals(12, ((Node<Integer>) list.getHead()).getData().intValue());
    }
    @Test
    public void getTail_getTail_getTailOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(12);
        list.pushFront(13);
        assertEquals(12, ((Node<Integer>) list.getTail()).getData().intValue());
    }
    @Test
    public void get_getValue_getOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(14);
        list.pushFront(13);
        list.pushFront(12);
        assertEquals(12, ((Node<Integer>)list.get(0)).getData().intValue() );
    }
    @Test
    public void get_ValueWithSizeIndex_GetIndexOutOfBoundsException(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        try {
            list.get(1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("index out of bounds", e.getMessage());
        }
    }
    @Test
    public void insertAfter_insertAfterValue_insertAfterOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> node = list.pushFront(12);
        list.insertAfter(node, 13);
        assertEquals(13, ((Node<Integer>) list.getTail()).getData().intValue());
    }
    @Test
    public void insertAfter_checkSizeAfterInsertAfter_sizeIncreasesByOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> node = list.pushFront(12);
        list.insertAfter(node, 13);
        assertEquals(2, list.getSize());
    }

    @Test
    public void insertBefore_insertBeforeValue_insertBeforeOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> node = list.pushFront(12);
        list.insertBefore(node, 13);
        assertEquals(13, ((Node<Integer>) list.getHead()).getData().intValue());
    }
    @Test
    public void insertBefore_checkSizeAfterInsertBefore_sizeIncreasesByOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> node = list.pushFront(12);
        list.insertBefore(node, 13);
        assertEquals(2, list.getSize());
    }
    @Test
    public void pushBack_pushBackValue_HeadTailSizeAreOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(13);
        list.pushBack(14);
        assertEquals(13, ((Node<Integer>) list.getHead()).getData().intValue());
        assertEquals(14, ((Node<Integer>) list.getTail()).getData().intValue());
        assertEquals(2, list.getSize());
    }
    @Test
    public void remove_removeElement_removeAndSizeAreOK(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> node1 = list.pushBack(13);
        Node<Integer> node2 = list.pushBack(14);
        Node<Integer> node3 = list.pushBack(15);

        list.remove(node2);

        assertEquals(node3, node1.getNext());
        assertEquals(node1, node3.getPrev());
        assertEquals(2, list.getSize());
    }
    @Test
    public void insertListAfter_insertListAfterList_insertListAfterListOK(){
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        Node<Integer> node1 = list1.pushBack(1);
        Node<Integer> node2 = list1.pushBack(2);
        Node<Integer> node3 = list1.pushBack(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        Node<Integer> node4 = list2.pushBack(4);
        Node<Integer> node5 = list2.pushBack(5);
        Node<Integer> node6 = list2.pushBack(6);

        list1.insertListAfter(node2, list2);

        assertEquals(node2, node1.getNext());
        assertEquals(node4, node2.getNext());
        assertEquals(node5, node4.getNext());
        assertEquals(node6, node5.getNext());
        assertEquals(node3, node6.getNext());
    }

    @Test
    public void insertListBefore_insertListBeforeList_insertListBeforeListOK(){
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        Node<Integer> node1 = list1.pushBack(1);
        Node<Integer> node2 = list1.pushBack(2);
        Node<Integer> node3 = list1.pushBack(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        Node<Integer> node4 = list2.pushBack(4);
        Node<Integer> node5 = list2.pushBack(5);
        Node<Integer> node6 = list2.pushBack(6);

        list1.insertListBefore(node2, list2);

        assertEquals(node4, node1.getNext());
        assertEquals(node5, node4.getNext());
        assertEquals(node6, node5.getNext());
        assertEquals(node2, node6.getNext());
        assertEquals(node3, node2.getNext());
    }
}
