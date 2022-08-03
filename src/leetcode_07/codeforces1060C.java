package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces1060C {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] a = new int[n];
        int[] prea = new int[n+1];
        int[] lena = new int[n+1];
        Arrays.fill(lena,Integer.MAX_VALUE);
        lena[0] = 0;
        st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(st.nextToken());
            prea[i+1] = prea[i] +a[i];
        }
        st = new StringTokenizer(sc.readLine());
        int[] b = new int[m];
        int[] preb = new int[m+1];
        int[] lenb = new int[m+1];
        Arrays.fill(lenb,Integer.MAX_VALUE);
        lenb[0] = 0;
        for (int i = 0; i < m; i++) {
            b[i] = Integer.valueOf(st.nextToken());
            preb[i+1] = preb[i] + b[i];
        }
        long k = Long.valueOf(sc.readLine());
        for (int i = 1; i < n+1; i++) {
            for (int j = i-1; j >=0; j--) {
                lena[i-j] = Math.min(lena[i-j],prea[i]-prea[j]);
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = i-1; j >=0; j--) {
                lenb[i-j] = Math.min(lenb[i-j],preb[i]-preb[j]);
            }
        }
        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            int l = 0,r = m;
            while (l<=r){
                int mid = (l+r)/2;
                if ((long)lena[i]*(long)lenb[mid]<=k){
                    ans = Math.max(ans,mid*i);
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }

        }
        out.println(ans);
        out.close();
    }
}
