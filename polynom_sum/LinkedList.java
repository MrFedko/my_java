package polynom_sum;
import java.io.*;

public class LinkedList {
    public static void main(String[] args) throws IOException {
        Node start1 = null, cur1 = null,
             start2 = null, cur2 = null;
        
        int[] list1_coeff = getCoeffAndPow("first.txt")[0];
        int[] list1_pow = getCoeffAndPow("first.txt")[1];

        for (int i = 0; i < list1_coeff.length; i++){
            Node ptr = new Node(list1_coeff[i], list1_pow[i]);
            if (start1 == null){
                start1 = ptr;
                cur1 = ptr;
            }
            else {
                cur1.next = ptr;
                cur1 = ptr;
            }
        }
        

        int[] list2_coeff = getCoeffAndPow("second.txt")[0];
        int[] list2_pow = getCoeffAndPow("second.txt")[1];

        for (int i = 0; i < list2_coeff.length; i++){
            Node ptr = new Node(list2_coeff[i], list2_pow[i]);
            if (start2 == null){
                start2 = ptr;
                cur2 = ptr;
            }
            else {
                cur2.next = ptr;
                cur2 = ptr;
            }
        }

        Polynomials obj = new Polynomials();
        Node sum = obj.addPolynom(start1, start2);
        Node trav = sum;
        FileWriter writ = new FileWriter("result_of_sum.txt");
        while (trav != null) 
        {
            if (trav.pow > 1){
                System.out.print(trav.coeff + "x^" + trav.pow);
                writ.write(String.valueOf(trav.coeff + "x^" + trav.pow));
            }
            else if (trav.pow == 1){
                System.out.print(trav.coeff + "x");
                writ.write(String.valueOf(trav.coeff + "x^" + trav.pow));
            }
            else {
                System.out.print(trav.coeff);
                writ.write(String.valueOf(trav.coeff + "x^" + trav.pow));
            }
            if (trav.next != null){
                if (trav.next.coeff >= 0){
                    System.out.print("+");
                    writ.write(String.valueOf("+"));
                }
                else {
                    System.out.print("");
                    writ.write(String.valueOf(""));
                }
                
            }
            trav = trav.next;
        }
        writ.close(); 
        System.out.println();
    }

    public static int[][] getCoeffAndPow(String name) throws IOException{
        BufferedReader fr = new BufferedReader(new FileReader(name));
        String c = fr.readLine();
        fr.close();
        int[] result_coef = new int[c.split("[+-]").length];
        int[] result_pow = new int[c.split("[+-]").length];
        
        String[] file = c.split("x");
        int index_coef = 0;
        int index_pow = 0;
        for (String string : file) 
        {
            if (index_coef == 0)
            {
                result_coef[index_coef] = Integer.parseInt(string);
                index_coef++;
            }
            else
            {
                if (string.indexOf("-") == -1 && string.indexOf("+") == -1)
                {
                    result_pow[index_pow] = Integer.parseInt(string.replace("^", ""));
                }
                else
                {
                    string = string.replace("^", "");
                    int ind = string.indexOf("-");
                    if (ind == -1) { ind = string.indexOf("+");};
                    result_coef[index_coef] = Integer.parseInt(string.substring(ind));
                    result_pow[index_pow] = Integer.parseInt(string.substring(0, ind));
                    index_coef++;
                    index_pow++;
                }
            }
        }
        int[][] result = {result_coef, result_pow};
        return result;
    }
}
