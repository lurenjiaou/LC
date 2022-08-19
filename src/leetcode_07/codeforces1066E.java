package leetcode_07;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces1066E {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        long ans = 0;
        long mod = 998244353;
        String str1 = in.readLine();
        String str2 = in.readLine();
        int len = 200005;
        int[] num1 = new int[len];
        int[] num2 = new int[len];
        for (int i = 0; i < n; i++) {
            num1[len-1-i] = str1.charAt(n-1-i)=='1' ? 1:0;
        }
        for (int i = 0; i < m; i++) {
            num2[len-1-i] = str2.charAt(m-1-i)=='1' ? 1:0;
        }
        long dp[] = new long[len];
        long[] presum = new long[len];
        dp[len-1] = 1;
        for (int i = 1; i < len; i++) {
            presum[i] = presum[i-1] + num2[i];
        }
        ans = num1[len-1]==1? presum[len-1]:0;
        for (int i = len-2; i >=0 ; i--) {
            dp[i] = 2 * dp[i + 1];
            dp[i] = dp[i] % mod;
            if (num1[i]==1) {
                ans += dp[i] * presum[i];
                ans = ans % mod;
            }
        }
        out.println(ans);
        out.close();
    }
}
