package comb_sort;

import sorting.Sorting;

public class combSort extends Sorting{

    static int[] array;

    public combSort(int[] ar) {
        array = ar;
    }

    private int[] combing(int[] anyArray) {
        Double factor = 1.247;
        Double step = (double) (anyArray.length - 1);

        while (step >= 1){
            for (int i = 0; i + step < anyArray.length; i++){
                if (anyArray[i] > anyArray[(int) (i+step)]) swap(anyArray, i, (int) (i + step));
            }
            printArray(anyArray);
            step /= factor;
        }
        
        return anyArray;
    }

    public static void main(String[] args) {
        combSort mySort = new combSort(getFromUser());
        mySort.combing(array);
        printArray(combSort.array);
    }
    
}
