package leetcode_07;

import java.io.*;
import java.util.StringTokenizer;

public class codeforces1249E {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] nums = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        int[] nums2 = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            nums2[i] = Integer.valueOf(st.nextToken());
        }
        int w = 0, l = c;
        out.print(0);
        for (int i = 0; i < n-1; i++) {
            int curw = Math.min(w,l)+nums[i];
            int curl = Math.min(w+c,l)+nums2[i];
            w = curw;
            l = curl;
            out.print(" "+Math.min(w,l));
        }
        out.close();
    }
}
