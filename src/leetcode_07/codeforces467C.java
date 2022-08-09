package leetcode_07;

import java.io.*;
import java.util.StringTokenizer;

public class codeforces467C {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(sc.readLine());
        long[] presum = new long[n+1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
            presum[i+1] = presum[i] + nums[i];
        }
        long ans = 0;
        long[] dp = new long[n+1];
        for (int i = 1; i <= k; i++) {
            long[] dp2 = new long[n+1];
            for (int j = m-1; j <n; j++) {
                dp2[j+1] = Math.max(dp2[j],dp[j+1-m]+presum[j+1]-presum[j+1-m]);
            }
            dp = dp2;
        }
        out.println(dp[n]);
        out.flush();
        sc.close();
        out.close();
    }
}
