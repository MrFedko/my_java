package polynom_sum;
import java.io.*;

public class GetFromFile {
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
