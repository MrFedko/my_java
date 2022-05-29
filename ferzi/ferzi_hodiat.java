package ferzi;

import java.util.Scanner;

public class ferzi_hodiat {
    int[] x;
    int count = 1;
    public ferzi_hodiat(int number) {
        x = new int[number];
    }

    public boolean canWePlaceFerz(int row, int num) {
        for (int i = 0; i < row; i++) {
            if (x[i] == num || (i - row) == (x[i] - num) || (i - row) == (num - x[i])) {
                return false;
            }
        }
        return true;
    }

    public void printBoard(int[] x) {
        System.out.printf("Board number %d", count);
        System.out.println();
        count++;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] == j) {
                    System.out.print("F ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void placeNextFerz(int row, int col) {
        for (int num = 0; num < col; num++) {
            if (canWePlaceFerz(row, num)) {
                x[row] = num;
                if (row == col - 1) {
                    printBoard(x);
                } else {
                    placeNextFerz(row + 1, col);
                }
            }
        }
    }

    public void callPlaceNextFerz() {
        placeNextFerz(0, x.length);
    }

    public static void main(String args[]) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int length of Board: ");
        int n = iScanner.nextInt();
        iScanner.close();
        ferzi_hodiat F = new ferzi_hodiat(n);
        F.callPlaceNextFerz();

    }
}
