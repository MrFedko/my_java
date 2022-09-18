package exceptions.HW3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class infoUser {
    
    public static void main(String[] args) throws IOException {
        String user = getInfo();
        fileWrite(user);

    }

    public static String getInfo() {
        Scanner input = new Scanner(System.in);

        System.out.print(
                "Введите через пробел в произвольном порядке\n" +
                        "- Фамилия Имя Отчество\n" +
                        "- дата рождения(dd.mm.yyyy)\n" +
                        "- номер телефона(только цифры)\n" +
                        "- пол(символ латиницей f или m):\n");

        String infoString = input.nextLine();
        while (!checkInfo(infoString)){
            System.out.println("Повторите ввод, данные не корректны ");
            infoString = input.nextLine();
        }
        input.close();
        return infoString;
    }

    public static boolean checkInfo(String text){
        int len = 6;
        return len == text.split(" ").length;
    }

    private static String[] getName(String text) {
        String[] fio = new String[3];
        Pattern namePattern = Pattern.compile(
            "[а-яА-ЯёЁa-zA-Z]{2,}+ [а-яА-ЯёЁa-zA-Z]{2,}+ ?[а-яА-ЯёЁa-zA-Z]{2,}+$", 
                Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = namePattern.matcher(text);
        if (nameMatcher.find()) {
            fio = nameMatcher.group().split(" ");
        }
        if (fio == null) {  
            throw new IllegalArgumentException("Неверно введены Фамилия Имя Отчество");  
        } 
        return fio;
    }

    private static String getDate(String text) {
        String dateOfBirth = null;
        Pattern datePattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)");
        Matcher dateMatcher = datePattern.matcher(text);
        if (dateMatcher.find()) {
            dateOfBirth = dateMatcher.group();
        }
        if (dateOfBirth == null) {  
            throw new IllegalArgumentException("Неверно введена дата рождения");  
        } 
        return dateOfBirth;
    }

    private static Long getTelephone(String text) {
        Long telephoneNumber = null;
        Pattern telPattern = Pattern.compile("[\\d]{11}");
        Matcher telMatcher = telPattern.matcher(text);
        if (telMatcher.find()) {
            telephoneNumber = Long.parseLong(telMatcher.group());
        }
        if (telephoneNumber == null) {  
            throw new IllegalArgumentException("Неверно введен номер телефона");  
        } 
        return telephoneNumber;
    }

    private static String getGender(String text) {
        String gend = null;
        for ( String word : text.split(" ")) {
            if (word.length() == 1 && (word.contains("f") || word.contains("m"))) {
                gend = word;
            }  
        }
        if (gend == null) {  
            throw new IllegalArgumentException("Неверно введен пол");  
        } 
        return gend;
    }

    public static void fileWrite(String text) throws IOException{
        String[] fio = getName(text);
        String dateOfBirth = getDate(text);
        Long telephone = getTelephone(text);
        String gender = getGender(text);
        FileWriter fw = new FileWriter(String.format("%s.txt", fio[0]), true);
        fw.write(String.format("<%s><%s><%s><%s><%d><%s>", 
                fio[0], fio[1], fio[2],
                dateOfBirth, telephone, gender));
        fw.append('\n');
        fw.close();
    }

}
