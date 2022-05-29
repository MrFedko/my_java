package hanoy_tower;
import java.util.Scanner;

public class tower_task {

    public static void main (String[] args) throws Exception{
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int count of discs: ");
        int count = iScanner.nextInt();
        iScanner.close();
        
        int with = 1;
        int on = 3;
        int some = 2;
        hanoy(with, on, some, count);
    }

    public static int hanoy(int with, int on, int some, int count){
        if (count > 0){
            hanoy (with, some, on, count - 1);
            System.out.printf("disk %d move %d >> %d",count, with, on);
            System.out.println();
            hanoy (some, on, with, count - 1);
        }
        return count;
    }
    
}
