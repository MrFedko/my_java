// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package ferzi;

import java.util.Scanner;

public class ferzi_ne_hodiat {

    int[] x;

    public ferzi_ne_hodiat(int N) {
        x = new int[N];
    }

    public boolean canPlaceFerz(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) || (i - r) == (c - x[i])) {
                return false;
            }
        }
        return true;
    }

    public void printFerz(int[] x) {
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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

    public void placeNFerz(int r, int n) {
        for (int c = 0; c < n; c++) {
            if (canPlaceFerz(r, c)) {
                x[r] = c;
                if (r == n - 1) {
                    printFerz(x);
                } else {
                    placeNFerz(r + 1, n);
                }
            }
        }
    }

    public void callplaceNferz() {
        placeNFerz(0, x.length);
    }

    public static void main(String args[]) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int count of discs: ");
        int n = iScanner.nextInt();
        iScanner.close();
        ferzi_ne_hodiat F = new ferzi_ne_hodiat(n);
        F.callplaceNferz();

    }

}