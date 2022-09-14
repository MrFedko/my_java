package exceptions;

public class square {
    static int[][] array = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 1, 1 } };
    static int[][] array1 = { { 1, 0, 1 }, { 0, 0 }, { 1, 1, 1 } };
    static int[][] array2 = { { 1, 0, 1 }, { 0, 2, 0 }, { 1, 1, 1 } };

    public static void main(String[] args) {
        System.out.println(findSum(array));
        System.out.println(findSum(array1));
        System.out.println(findSum(array2));
    }

    public static int findSum(int[][] ar){
        int result = 0;
        int len = ar.length;
        
        for (int i = 0; i < len; i++){
            if (ar[i].length < len) throw new RuntimeException("Это не квадратный массив");
            
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] != 1 && ar[i][j] != 0) 
                    throw new RuntimeException("Значение в массиве отличается от 0 и 1");
                result += ar[i][j];   
            }
        }
        return result;
    }

}
