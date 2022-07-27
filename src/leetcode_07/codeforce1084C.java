package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class codeforce1084C {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String st = sc.readLine();
        char[] str = st.toCharArray();
        long res = 0L;
        long last = 0L;
        long cur = 0L;
        long mod = 1000000007L;
        for (int i = 0; i < str.length; i++) {
            if (str[i]=='a'){
                long tmp = 1L;
                tmp += last;
                tmp = tmp%mod;
                res += tmp;
                res %= mod;
                tmp %=mod;
                cur +=tmp;
                cur %=mod;
            }
            if (str[i]=='b'){
                last = cur;
            }
        }
        out.println(res);
        out.close();
    }
}
