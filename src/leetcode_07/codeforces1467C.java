package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces1467C {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        long[] nums = new long[a+b+c];
        st = new StringTokenizer(sc.readLine());
        long[] nums_a = new long[a];
        long sum_a = 0;
        for (int i = 0; i < a; i++) {
            nums[i] = Long.valueOf(st.nextToken());
            nums_a[i] = nums[i];
            sum_a +=nums[i];
        }
        st = new StringTokenizer(sc.readLine());
        long sum_b = 0;
        long[] nums_b = new long[b];
        for (int i = 0; i < b; i++) {
            nums[i+a] = Long.valueOf(st.nextToken());
            nums_b[i] = nums[i+a];
            sum_b += nums_b[i];
        }
        st = new StringTokenizer(sc.readLine());
        long sum_c = 0;
        long[] nums_c= new long[c];
        for (int i = 0; i < c; i++) {
            nums[i+a+b] = Long.valueOf(st.nextToken());
            nums_c[i] = nums[i+a+b];
            sum_c += nums_c[i];
        }
        Arrays.sort(nums);
        Arrays.sort(nums_a);
        Arrays.sort(nums_b);
        Arrays.sort(nums_c);
        long ans = Math.max(sum_a+sum_b-sum_c,Math.max(sum_a+sum_c-sum_b,sum_b+sum_c-sum_a));
        long sum = sum_a+sum_b+sum_c;
        ans = Math.max(ans,Math.max(sum-2*nums_a[0]-2*nums_b[0],Math.max(sum-2*(nums_a[0]+nums_c[0]),sum-2*(nums_b[0]+nums_c[0]))));
        out.println(ans);
        out.close();
    }
}
