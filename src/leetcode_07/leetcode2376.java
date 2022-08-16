package leetcode_07;

import java.util.Arrays;

public class leetcode2376 {
    char[] nums;
    int[][] dp;
    public int countSpecialNumbers(int n) {
        nums = Integer.toString(n).toCharArray();
        dp = new int[nums.length][1<<10];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i],-1);
        }

        return f(0,0,true,false);
    }

    private int f(int i, int mask, boolean islimit, boolean isnum) {
        if (i==nums.length)return isnum? 1:0;
        if (!islimit&&isnum&&dp[i][mask]>0)return dp[i][mask];
        int ans = 0;
        int begin = 0;
        if (!isnum) {
            ans = f(i + 1, mask, false, false);
            begin = 1;
        }
        int up = islimit? nums[i]-'0':9;
        for (int j = begin; j < up+1; j++) {
            if ((mask&(1<<j))==0)
            ans += f(i+1,mask|(1<<j),islimit&&j==up,true);
        }
        if (!islimit&&isnum)dp[i][mask] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode2376().countSpecialNumbers(200));
    }
}
