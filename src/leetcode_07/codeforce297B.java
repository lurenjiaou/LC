package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforce297B {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(sc.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(st.nextToken());
        }
        int[] b = new int[m];
        st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.valueOf(st.nextToken());
        }
        if (n>m)out.println("YES");
        else {
            Arrays.sort(a);
            Arrays.sort(b);
            int indexa = n-1;
            int indexb = m-1;
            while (indexa>=0){
                if (a[indexa]>b[indexb]){
                    out.println("YES");
                    out.close();
                    return;
                }
                indexa--;
                indexb--;
            }
            out.println("NO");
        }
        out.close();
    }
}
