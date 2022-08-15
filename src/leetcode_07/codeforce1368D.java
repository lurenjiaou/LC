package leetcode_07;

import java.io.*;
import java.util.StringTokenizer;

public class codeforce1368D {
    public static void main(String[] args) throws IOException {
        final BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = Integer.valueOf(in.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }
        out.println(process(nums));
        out.close();
    }

    private static long process(int[] nums) {
        long ans = 0;
        int[] count = new int[21];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 20; j++) {
                if ((nums[i]&(1<<j))!=0)count[j]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            long cur = 0;
            for (int j = 20; j >=0; j--) {
                cur*=2;
                if (count[j]>0){
                    cur+=1;
                    count[j]--;
                }
            }
            ans += cur*cur;
        }
        return ans;
    }
}
