package exceptions.HW1;

public class twoArrays {
    public static void main(String[] args) {
        int[] arr1 = { 7, 1, 4, 9, 0, 2, 4, 5 };
        int[] arr2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        newArray(arr1, arr2);
    }

    public static int[] newArray(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Is not same size of arrays");
        }
        int[] result = new int[min(array1.length, array2.length)];
        for (int i = 0; i < min(array1.length, array2.length); i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;
    }

    private static int min(int length, int length2) {
        return length > length2 ? length2 : length;
    }

}
