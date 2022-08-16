package leetcode_07;

import java.util.Arrays;

public class leetcode1012 {
    private char[] nums;
    private int[][][] dp;
    public int numDupDigitsAtMostN(int n) {
        nums = Integer.toString(n).toCharArray();
        dp = new int[nums.length][1<<10][2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 1<<10; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans = f1(0,0,true,false,false);
        return ans;
    }

    private int f1(int i, int mask, boolean is_limit, boolean is_nums, boolean is_ans) {
        if (i==nums.length)return is_ans? 1:0;
        if (!is_limit&&is_nums&&dp[i][mask][is_ans?0:1]>0)return dp[i][mask][is_ans?0:1];
        int res = 0;
        int begin = 0;
        if (!is_nums) {
            res = f1(i + 1, mask, false, false, false);
            begin = 1;
        }
        int up = is_limit? nums[i]-'0':9;
        for (int j = begin; j < up+1; j++) {

            boolean cur = (is_ans||((mask&(1<<j))!=0));
            res += f1(i+1,(mask|(1<<j)),is_limit&&j==up,true,cur);
        }
        if (!is_limit&&is_nums)dp[i][mask][is_ans?0:1] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode1012().numDupDigitsAtMostN(120));
    }
}
