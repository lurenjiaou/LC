package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces482B {
    static int[][] p;
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        p = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            p[i][0] = Integer.valueOf(st.nextToken())-1;
            p[i][1] = Integer.valueOf(st.nextToken())-1;
            p[i][2] = Integer.valueOf(st.nextToken());
        }
        int[] ans = new int[n];
        for (int i = 0; i < 30; i++) {
            int[] dif = new int[n+1];
            for (int j = 0; j < m; j++) {
                if (((p[j][2]&(1<<i))!=0)){
                    dif[p[j][0]]++;
                    dif[p[j][1] + 1]--;
                }
            }
            for (int j = 1; j < n+1; j++) {
                dif[j] += dif[j-1];
            }
            for (int j = 0; j < n+1; j++) {
                if (dif[j]>0)dif[j] = 1;
            }
            int[] presum = new int[n+1];
            presum[0] = dif[0];
            for (int j = 1; j < n+1; j++) {
                presum[j] = presum[j-1] + dif[j];
            }
            //检查
            for (int j = 0; j < m; j++) {
                if ((p[j][2]&(1<<i))==0){
                    int k = presum[p[j][1]];
                    k -= p[j][0] == 0 ? 0 : presum[p[j][0]-1];
                    if (k == p[j][1] - p[j][0] + 1) {
                        out.println("NO");
                        out.close();
                        return;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (dif[j]==1)ans[j] |=(1<<i);
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(ans[i]+" ");
        }
        out.println();
        out.close();
    }
}
