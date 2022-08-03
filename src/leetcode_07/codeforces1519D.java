package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class codeforces1519D {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.valueOf(sc.readLine());
        long[] a = new long[n];
        long[] b = new long[n];
        StringTokenizer st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < n; ++i) {
            a[i] = Long.valueOf(st.nextToken());
        }
        st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < n; ++i) {
            b[i] = Long.valueOf(st.nextToken());
        }
        long sum = process(a,b);
        out.println(sum);
        out.close();
    }

    private static long process(long[] a, long[] b) {
        int n = a.length;
        long[] sum = new long[n+1];
        long[][] re_sum = new long[n][n];
        long maxgap = 0;
        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + a[i]*b[i];
            re_sum[i][i] = a[i]*b[i];
        }
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i+l-1< n; ++i) {
                int j = i+l-1;
                re_sum[i][j] = re_sum[i+1][j-1]+a[i]*b[j]+a[j]*b[i];
                maxgap = Math.max(maxgap,re_sum[i][j]-(sum[j+1]-sum[i]));
            }
        }
        return maxgap + sum[n];
    }
}
