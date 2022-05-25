package polynom_sum;

import java.io.*;

public class LinkedList {
    public static void main(String[] args) throws IOException {
        Node start1 = null, cur1 = null,
                start2 = null, cur2 = null;

        int[][] list1 = GetFromFile.getCoeffAndPow("first.txt");

        for (int i = 0; i < list1[0].length; i++) {
            Node ptr = new Node(list1[0][i], list1[1][i]);
            if (start1 == null) {
                start1 = ptr;
                cur1 = ptr;
            } else {
                cur1.next = ptr;
                cur1 = ptr;
            }
        }

        int[][] list2 = GetFromFile.getCoeffAndPow("second.txt");

        for (int i = 0; i < list2[0].length; i++) {
            Node ptr = new Node(list2[0][i], list2[1][i]);
            if (start2 == null) {
                start2 = ptr;
                cur2 = ptr;
            } else {
                cur2.next = ptr;
                cur2 = ptr;
            }
        }

        Polynomials obj = new Polynomials();
        Node sum = obj.addPolynom(start1, start2);
        Node trav = sum;
        FileWriter writ = new FileWriter("result_of_sum.txt");
        while (trav != null) {
            if (trav.pow > 1) {
                System.out.print(trav.coeff + "x^" + trav.pow);
                writ.write(String.valueOf(trav.coeff + "x^" + trav.pow));
            } else if (trav.pow == 1) {
                System.out.print(trav.coeff + "x");
                writ.write(String.valueOf(trav.coeff + "x^" + trav.pow));
            } else {
                System.out.print(trav.coeff);
                writ.write(String.valueOf(trav.coeff + "x^" + trav.pow));
            }
            if (trav.next != null) {
                if (trav.next.coeff >= 0) {
                    System.out.print("+");
                    writ.write(String.valueOf("+"));
                } else {
                    System.out.print("");
                    writ.write(String.valueOf(""));
                }

            }
            trav = trav.next;
        }
        writ.close();
        System.out.println();
    }
}
