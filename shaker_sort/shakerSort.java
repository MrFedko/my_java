package shaker_sort;

import sorting.Sorting;

public class shakerSort extends Sorting {

    static int[] array;

    public shakerSort(int[] ar) {
        array = ar;
    }

    public int[] shaker(int[] anyArray){
        int left = 0;
        int right = anyArray.length - 1;
        while (left <= right){
            for (int i= right; i > left; i--){
                if (anyArray[i-1] > anyArray[i]) swap(anyArray, i-1, i);

            }
            left++;
            for (int i = left; i < right; i ++){
                if (anyArray[i] > anyArray[i+1]) swap(anyArray, i, i+1);
            }
            right--;
        }
        
        return anyArray;
    }

    public static void main(String[] args) {
        shakerSort mySort = new shakerSort(getFromUser());
        mySort.shaker(array);
        printArray(shakerSort.array);
    }

}
