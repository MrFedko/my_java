package heapSort;

import java.util.Scanner;
import java.util.stream.Stream;

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
            int temp = array[i];
            array[i] = array[largestNumber];
            array[largestNumber] = temp;
            heapyfi(array, lenArray, largestNumber);
        }
    }

    public void nowWeCanSort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--)
            heapyfi(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapyfi(array, i, 0);
        }
    }

    static void printArray(int array[]) {
        int length = array.length;
        for (int i = 0; i < length; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter numbers separated by spaces: ");
        int myArray[] = Stream.of(iScanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        iScanner.close();

        myHeapSort mySorting = new myHeapSort();
        mySorting.nowWeCanSort(myArray);

        System.out.println("Now we got an array:");
        printArray(myArray);
    }

}
