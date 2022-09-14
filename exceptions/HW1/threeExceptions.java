package exceptions.HW1;

public class threeExceptions {
    public static void main(String[] args) {
        Exceptions Exceptions = new Exceptions();

        Exceptions.ExceptionStackOverflow(1);
        Exceptions.ArrayStoreException();
        Exceptions.NegativeArraySizeException(-1); 
    }
}

class Exceptions {
    public void ExceptionStackOverflow(int counter) {
        if (counter == 0)
            return;
        else
            ExceptionStackOverflow(++counter);
    }

    public void ArrayStoreException() {
        Object[] any = new String[1];
        any[0] = 1;
        System.out.println(any[0]);
    }

    public void NegativeArraySizeException(int size) {
        int[] array = new int[size];
    }
}