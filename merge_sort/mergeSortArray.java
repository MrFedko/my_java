package merge_sort;

import sorting.Sorting;

public class mergeSortArray {

    static int[] array;

    public mergeSortArray(int[] ar) {
        array = ar;
    }

    public int[] mergeArray(int[] first, int[] second) {
        int[] third = new int[first.length + second.length];
        int posFirst = 0, posSecond = 0;
        for (int i = 0; i < third.length; i++) {
            if (posFirst == first.length) {
                third[i] = second[posSecond];
                posSecond++;
            } else if (posSecond == second.length) {
                third[i] = first[posFirst];
                posFirst++;
            } else if (first[posFirst] < second[posSecond]) {
                third[i] = first[posFirst];
                posFirst++;
            } else {
                third[i] = second[posSecond];
                posSecond++;
            }
        }
        return third;
    }

    public int[] sortArray(int[] first) {
        if (first.length < 2) return first;

        int[] second = new int[first.length / 2];
        System.arraycopy(first, 0, second, 0, first.length / 2);

        int[] third = new int[first.length - first.length / 2];
        System.arraycopy(first, first.length / 2, third, 0, first.length - first.length / 2);

        second = sortArray(second);
        third = sortArray(third);
        return mergeArray(second, third);
    }


    public static void main(String[] args) {
        int[] fromUser = Sorting.getFromUser();

        mergeSortArray Merge = new mergeSortArray(fromUser);
        Sorting.printArray(Merge.sortArray(array));
    }

}
