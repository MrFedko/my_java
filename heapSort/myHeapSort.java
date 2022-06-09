package heapSort;

import sorting.Sorting;

public class myHeapSort {

    void heapyfi(int[] array, int lenArray, int i) {
        int largestNumber = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < lenArray && array[leftChild] > array[largestNumber])
            largestNumber = leftChild;
        if (rightChild < lenArray && array[rightChild] > array[largestNumber])
            largestNumber = rightChild;
        if (largestNumber != i) {
            Sorting.swap(array, i, largestNumber);
            heapyfi(array, lenArray, largestNumber);
        }
    }

    public void nowWeCanSort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--)
            heapyfi(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            Sorting.swap(array, 0, i);
            heapyfi(array, i, 0);
        }
    }

    public static void main(String args[]) {
        int[] myArray = Sorting.getFromUser();

        myHeapSort mySorting = new myHeapSort();
        mySorting.nowWeCanSort(myArray);

        System.out.println("Now we got an array:");
        Sorting.printArray(myArray);
    }

}
