package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces1038B {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(sc.readLine());
        PrintWriter out = new PrintWriter(System.out);
        long[] nums = new long[n];
        StringTokenizer st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Long.valueOf(st.nextToken());
        }
        if (n==1){
            out.println(nums[0]);
            out.close();
            return;
        }
        Arrays.sort(nums);
        long ans = nums[n-1]-nums[0];
        for (int i = 1; i < n-1; i++) {
            ans +=Math.abs(nums[i]);
        }
        out.println(ans);
        out.close();
    }
}