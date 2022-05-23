package polynom_sum;

public class Node {
    int coeff;
    int pow;
    Node next;

    Node(int a, int b) {
        coeff = a;
        pow = b;
        next = null;
    }
}