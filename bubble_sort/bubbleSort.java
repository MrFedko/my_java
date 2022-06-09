package bubble_sort;

import sorting.Sorting;

public class bubbleSort extends Sorting {

    static int[] array;

    public bubbleSort(int[] myArray) {
        array = myArray;
    }

    public int[] bubbles(int[] array) {
        int length = array.length;
        for (int i = 0; i + 1 < length; i++) {
            for (int j = 0; j + 1 < length - i; j++) {
                if (array[j + 1] < array[j])
                    swap(array, j, j + 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        bubbleSort mySort = new bubbleSort(getFromUser());
        mySort.bubbles(array);
        printArray(bubbleSort.array);
    }
}
