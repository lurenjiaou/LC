package test1;

public class problem3 {
    public int numsOfStrings (int n, int k) {
        // write code here
        int mod = 1000000;
        int [][][]dp = new int[n+1][k+1][2];
        dp[1][0][0] = 26;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <=k; j++) {
                dp[i][j][0] = dp[i-1][j][1]*25;
                dp[i][j][0] %=mod;
                dp[i][j][1] = dp[i-1][j-1][0]+dp[i-1][j][1];
                dp[i][j][1] %=mod;
            }
        }
        return dp[n][k][1];
    }

    public static void main(String[] args) {
        System.out.println(new problem3().numsOfStrings(4,2));
    }
}
