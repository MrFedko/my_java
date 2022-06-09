package sorting;

import java.util.Scanner;
import java.util.stream.Stream;

public class Sorting {
    public static void swap(int[]array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    public static void printArray(int array[]) {
        int length = array.length;
        for (int i = 0; i < length; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public static int[] getFromUser(){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter numbers separated by spaces: ");
        int myArray[] = Stream.of(iScanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        iScanner.close();
        return myArray;
    }
}
