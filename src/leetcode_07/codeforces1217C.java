package leetcode_07;

import java.io.*;

public class codeforces1217C {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.valueOf(in.readLine());
        while (t>0){
            String str = in.readLine();
            out.println(process(str));
            t--;
        }
        in.close();
        out.close();
    }

    private static int process(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str[i]=='0')count++;
            else {
                int cur = 0;
                for (int j = i; j < n; j++) {
                    cur*=2;
                    cur+= str[j]=='1'? 1:0;
                    if (count+j-i+1>=cur)ans++;
                    else break;
                }
                count = 0;
            }
        }
        return ans;
    }
}
