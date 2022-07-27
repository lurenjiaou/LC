package leetcode_07;

import java.io.*;
import java.util.StringTokenizer;

public class codeforce1192D extends Object{
    public int a = 5;
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(sc.readLine());
        int[] ans = new int[t];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(sc.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            ans[i] = process(n,k, sc.readLine());
        }
        for (int i = 0; i < t; i++) {
            out.println(ans[i]);
        }
        out.close();
    }

    private static int process(int n, int k, String strs) {
        int res = k;
        if (k==1)return 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (strs.charAt(i)=='R')nums[i] = 0;
            if (strs.charAt(i)=='G')nums[i] = 1;
            if (strs.charAt(i)=='B')nums[i] = 2;
        }
        //i表示偏移
        //
        for (int i = 0; i < 3&&i+k<=n; i++) {
            for (int begin = 0; begin < 3; begin++) {
                int cur = 0;
                for (int j = 0; j < k; j++) {
                    if (nums[i+j]!=((begin+j)%3))cur++;
                }
                res = Math.min(cur,res);
                int index = k+i;
                while (index+2<n){
                    if (nums[index-k]!=begin%3)cur--;
                    if (nums[index-k+1]!=(begin+1)%3)cur--;
                    if (nums[index-k+2]!=(begin+2)%3)cur--;
                    if (nums[index]!=(begin+k)%3)cur++;
                    if (nums[index+1]!=(begin+k+1)%3)cur++;
                    if (nums[index+2]!=(begin+k+2)%3)cur++;
                    res = Math.min(cur,res);
                    index +=3;
                }
            }
        }
        return res;
    }
}
