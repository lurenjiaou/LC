package leetcode_07;

import java.util.Scanner;

public class codeforce1051D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] in = input.split(" ");
        int n = Integer.valueOf(in[0]);
        int k = Integer.valueOf(in[1]);
        int md = 998244353;
        int[][] dp = new int[4][2 * n + 1];
        dp[0][1] = 1;
        dp[3][1] = 1;
        dp[2][2] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            int[][] curdp = new int[4][k + 1];
            for (int j = k; j >= 1; j--) {
                curdp[0][j] = ((dp[0][j] + dp[1][j]) % md + dp[2][j]) % md + dp[3][j - 1];
                curdp[0][j] %= md;
                if (j > 1) curdp[1][j] = ((dp[1][j] + dp[2][j - 2]) % md + dp[0][j - 1]) % md + dp[3][j - 1];
                curdp[1][j] %= md;
                if (j > 1) curdp[2][j] = ((dp[2][j] + dp[1][j - 2]) % md + dp[0][j - 1]) % md + dp[3][j - 1];
                curdp[2][j] %= md;
                curdp[3][j] = ((dp[3][j] + dp[1][j]) % md + dp[2][j]) % md + dp[0][j - 1];
                curdp[3][j] %= md;
            }
            dp = curdp;
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += dp[i][k];
            ans %= md;
        }
        System.out.println(ans);
    }
}
