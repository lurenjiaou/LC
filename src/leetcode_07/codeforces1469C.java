package leetcode_07;

import java.io.*;
import java.util.StringTokenizer;

public class codeforces1469C {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.valueOf(sc.readLine());
        while (t>0){
            StringTokenizer st = new StringTokenizer(sc.readLine());
            int n = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            int[] nums = new int[n];
            st = new StringTokenizer(sc.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(st.nextToken());
            }
            boolean flag = process(nums,k);
            if (flag){
                out.println("YES");
            }else {
                out.println("NO");
            }
            t--;
        }
        out.close();
    }

    private static boolean process(int[] nums, int k) {
        int n = nums.length;
        int maxh = nums[0];
        int minh = nums[0];
        for (int i = 1; i < n; i++) {
            int curmaxh = nums[i] + k-1;
            int curminh = nums[i];
            curmaxh = Math.min(curmaxh,maxh+k-1);
            curminh = Math.max(curminh,minh+1-k);
            if (curmaxh<curminh)return false;
            maxh = curmaxh;
            minh = curminh;
        }
        if (nums[n-1]>maxh||nums[n-1]<minh)return false;
        return true;
    }
}
