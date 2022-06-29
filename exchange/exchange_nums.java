
// Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

package exchange;
import java.util.ArrayList;
import java.util.List;

public class exchange_nums {
    public static void main (String[] args){
        restore("2?+?5=69");
        }
    

    public static void restore(String str) {
        List<Integer> questionFind = new ArrayList<>();
        char[] elemOfExpr = str.replace(" ", "").toCharArray();
        for (int i = 0; i < elemOfExpr.length; i++) {
            if (elemOfExpr[i] == '+' || elemOfExpr[i] == '=') {
                elemOfExpr[i] = '-';
            }
            if (elemOfExpr[i] == '?') {
                questionFind.add(i);
            }
        }

        List<List<Integer>> combL = combinationIterative1(9, questionFind.size());

        for (int i = 0; i < combL.size(); i++) {

            List<Integer> tmp = combL.get(i);
            for (int j = 0; j < questionFind.size(); j++) {
                elemOfExpr[questionFind.get(j)] = (char) (tmp.get(j) + 48);
            }

            StringBuilder sb = new StringBuilder();
            List<Integer> tmpLi = new ArrayList<>();
            for (int j = 0; j < elemOfExpr.length; j++) {
                if (elemOfExpr[j] == '-') {
                    tmpLi.add(Integer.valueOf(String.valueOf(sb)));
                    sb = new StringBuilder();
                } else
                    sb.append(elemOfExpr[j]);
            }
            tmpLi.add(Integer.valueOf(String.valueOf(sb)));

            int firstN = tmpLi.get(0);
            int secondN = tmpLi.get(1);
            int resultN = tmpLi.get(2);

            if (firstN + secondN == resultN) {
                System.out.printf("%s + %s = %s\n", firstN, secondN, resultN);
            }
        }
    }

    public static List<List<Integer>> combinationIterative1(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();
        int[] a = new int[k];
        int i = k - 1;
        while (i >= 0) {
            if (a[i] >= n) {
                a[i] = 0;
                i--;
            } else {
                a[i]++;
                if (i != k - 1) {
                    i = k - 1;
                }

                List<Integer> ll = new ArrayList<Integer>();
                for (int x : a)
                    ll.add(x);

                l.add(ll);
            }
        }
        return l;
    }
}
