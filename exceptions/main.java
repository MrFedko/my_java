package exceptions;

public class main {

    static int len = 3;
    static int num = 42;

    public static void main(String[] args) {
        int[] array = { 1, 3, 42, 61, 89 };

        System.out.println(message(findElement(array, num)));
    }

    public static String message(int num) {
        StringBuilder sb = new StringBuilder();
        switch (num) {
            default:
                sb.append("элемент найден и его индекс " + num);
                break;
            case -1:
                sb.append("Массив меньше " + len);
                break;
            case -2:
                sb.append("Искомый элемент не найден");
                break;
            case -3:
                sb.append("Ты подсунул мне null");
                break;
        }
        return sb.toString();
    }

    public static int findElement(int[] array, int number) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (number == array[i])
                result = i;
        }

        if (array == null)
            result = -3;
        if (array.length < len)
            result = -1;
        if (result == 0)
            result = -2;

        return result;
    }

}
