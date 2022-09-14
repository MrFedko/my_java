package exceptions.HW2;

import java.util.Scanner;

public class nullOnString {
    
    public static void main(String[] args) {
        inputNotNull();
    }

    public static void inputNotNull() {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите не пустую строку: ");
        String anything = input.nextLine();
        try { 
            anything = anything.replaceAll(" ", "");
            int num = 1 / anything.length();
            
        } catch (Exception e) {
            System.out.println("пустые строки вводить нельзя");
        }
    }
}