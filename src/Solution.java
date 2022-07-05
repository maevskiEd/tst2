import java.io.*;
import java.util.Scanner;

public class Solution {
    public int getMul() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/data.txt"));
        int max;
        String ss = "";
        String[] arr;

        if (scanner.hasNextInt()) {
            max = scanner.nextInt();
            while (scanner.hasNextInt()) {
                ss = getDlNumber(max, scanner.nextInt(), ss);
            }
            System.out.println(ss);
            arr = ss.split(",");
            max = 1;
            for (String item : arr) {
                max *= Integer.valueOf(item);
            }
            return max;
        } else return -1;
    }

    public String getDlNumber(int max, int num, String s) {
        if (num <= max) {
            for (int i = num; i <= max; i += num) {
                if (s.indexOf(String.valueOf(i)) == -1) s += i + ",";
            }
        }
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        System.out.println(s.getMul());
    }
}