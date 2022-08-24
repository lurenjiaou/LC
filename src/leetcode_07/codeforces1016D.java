package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class codeforces1016D {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] nums1 = new int[n];
        st = new StringTokenizer(in.readLine());
        int a = 0;
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.valueOf(st.nextToken());
            a = a^nums1[i];
        }
        st = new StringTokenizer(in.readLine());
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = Integer.valueOf(st.nextToken());
            a = a^nums2[i];
        }
        if (a!=0){
            out.println("NO");
            out.close();
            return;
        }
        int[][] ans = new int[n][m];
        int b = 0;
        for (int i = 1; i < n; i++) {
            ans[i][0] = nums1[i];
            b ^= nums1[i];
        }
        for (int i = 1; i < m; i++) {
            ans[0][i] = nums2[i];
        }
        ans[0][0] = nums2[0]^b;
        out.println("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(ans[i][j]);
                if (j!=m-1)out.print(" ");
            }
            out.println();
        }
        out.close();
    }
}
