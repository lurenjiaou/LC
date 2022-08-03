package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class codeforces1043 {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[][] nums = new int[m][n+1];
        int[][] indexs = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(sc.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.valueOf(st.nextToken());
                indexs[i][nums[i][j]] = j;
            }
        }
        if (m==1){
            long t = (long)n*(long)(n+1)/2;
            out.println(t);
            out.close();
            return;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int len = 1;
            boolean flag = true;
            while ((i+len)<n&&flag){
                int cur  = nums[0][i+len-1];
                int next = nums[0][i+len];
                for (int j = 1; j < m; j++) {
                    if (indexs[j][next]!=indexs[j][cur]+1){
                        flag=false;
                        break;
                    }
                }
                if (flag)len++;
            }
            ans +=(long)len*(long)(len+1)/2;
            i = i+len-1;
        }
        out.println(ans);
        out.close();
    }
}
