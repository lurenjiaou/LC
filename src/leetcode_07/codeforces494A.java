package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class codeforces494A {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        char[] str = sc.readLine().toCharArray();
        int count = 0;
        int num = 0;
        for (int i = str.length-1;i >-1; i--) {
            if (str[i]=='(')num++;
            if (str[i]==')')num--;
            if (str[i]=='#') {
                num--;
                count++;
            }
            if (num>0&&count==0){
                out.println(-1);
                out.close();
                return;
            }
        }
        num = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i]=='(')num++;
            if (str[i]==')')num--;
            if (str[i]=='#')num--;
            if (num<0){
                out.println(-1);
                out.close();
                return;
            }
        }
        for (int i = 0; i < count-1; i++) {
            out.println(1);
        }
        out.println(1+num);
        out.close();
        return;
    }
}
