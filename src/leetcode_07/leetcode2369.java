package leetcode_07;

import java.util.Arrays;

public class leetcode2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][3];
        Arrays.fill(dp[0],true);
        for (int i = 1; i < n; i++) {
            dp[i+1][0] = (dp[i-1][0]||dp[i-1][1]||dp[i-1][2])&&(nums[i]==nums[i-1]);
            if (i>1)dp[i+1][1] = (nums[i]==nums[i-1])&&dp[i][0];
            if (i>1)dp[i+1][2] = (nums[i]==nums[i-1]+1&&nums[i-1]==nums[i-2]+1)&&(dp[i-2][0]||dp[i-2][1]||dp[i-2][2]);
        }
        return dp[n][0]||dp[n][1]||dp[n][2];
    }

    public static void main(String[] args) {
        System.out.println(new leetcode2369().validPartition(new int[]{4,5,6}));
    }
}
