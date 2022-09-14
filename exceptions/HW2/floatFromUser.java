package exceptions.HW2;

import java.util.Scanner;

public class floatFromUser {

    public static void main(String[] args) {
        System.out.println(inputFloat());
    }

    public static float inputFloat() {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите дробное число: ");
        String number = input.nextLine();
        while (!number.contains(".")) {
            System.out.print("Не верный ввод повторите попытку: ");
            number = input.nextLine();
        }
        return Float.parseFloat(number);
    }
}
