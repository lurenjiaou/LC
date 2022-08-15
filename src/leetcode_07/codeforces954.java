package leetcode_07;

import java.io.*;
import java.util.StringTokenizer;

public class codeforces954 {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = Integer.valueOf(in.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }
        int y = 1;
        int maxnum = 1;
        for (int i = 1; i < n; i++) {
            if (y==1)y = Math.abs(nums[i]-nums[i-1]);
            maxnum = Math.max(maxnum,nums[i]);
        }
        if (y==0){
            out.println("NO");
            out.close();
            return;
        }
        if (y==1){
            out.println("YES");
            out.println("1000000000 1");
            out.close();
            return;
        }
        int x = maxnum/y;
        x += maxnum%y==0? 0:1;
        boolean flag = true;
        int cury = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i]-nums[i-1]==1)cury++;
            else if (nums[i]-nums[i-1]==1)cury--;
            else {
                cury = 0;
            }
            if (Math.abs(cury)>y)flag = false;
            if (Math.abs(nums[i]-nums[i-1])!=y&&Math.abs(nums[i]-nums[i-1])!=1){
                flag = false;
                break;
            }
            if (nums[i-1]%y==0&&nums[i]-nums[i-1]==1)flag = false;
            if (nums[i]%y==0&&nums[i-1]-nums[i]==1)flag = false;
        }
        if (flag){
            out.println("YES");
            out.println(1000000000+" "+y);
        }else {
            out.println("NO");
        }
        out.close();
    }
}
