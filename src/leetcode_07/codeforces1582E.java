package leetcode_07;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces1582E {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.valueOf(in.readLine());
        while (t>0){
            int n = Integer.valueOf(in.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(st.nextToken());
            }
            out.println(process(nums));
            t--;
        }
        in.close();
        out.close();
    }

    private static int process(int[] nums) {
        int n = nums.length;
        int ans = 1;
        long[] presum = new long[n+1];
        for (int i = 0; i < n; i++) {
            presum[i+1] = presum[i]+nums[i];
        }
        long[] dp = new long[n];
        dp[n-1] = nums[n-1];
        for (int i = n-2; i >=0; i--) {
            dp[i] = Math.max(dp[i+1],nums[i]);
        }
        int begin = 1;
        for (int i = 2; i <=n; i++) {
            begin +=i;
            long[] dp2 = new long[n];
            boolean flag = false;
            for (int j = n-begin; j >=0; j--) {
                long sum = presum[j+i]- presum[j];
                dp2[j] = dp2[j+1];
                if (sum<dp[j+i]){
                    flag = true;
                    dp2[j] =Math.max(sum,dp2[j+1]);
                }
            }
            if (flag){
                dp = dp2;
            }else {
                return i-1;
            }
        }
        return ans;
    }
}
