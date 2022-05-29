package ferzi;

import java.util.Scanner;

public class placeOfFerz {
    int[] board;
    int count = 1;

    public placeOfFerz(int number) {
        board = new int[number];
    }

    private void placeNextFerz(int next) {
        if (next == board.length) {
            print();
            return;
        }

        for (int i = 0; i < board.length; i++) {
            board[next] = i;
            if (canWePlacedFerz(next)) {
                placeNextFerz(next + 1);
            }
        }
    }

    private boolean canWePlacedFerz(int n) {
        for (int i = 0; i < n; i++) {
            if (board[i] == board[n] || Math.abs(n - i) == Math.abs(board[n] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.printf("Board number %d", count);
        System.out.println();
        count++;
        for (int k = 0; k < board.length; k++) {
            System.out.printf("%d ", board[k]);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String ch = board[i] == j ? "F ": "* ";
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int length of Board: ");
        int number = iScanner.nextInt();
        iScanner.close();

        placeOfFerz Ferz = new placeOfFerz(number);
        Ferz.placeNextFerz(0);
    }
}