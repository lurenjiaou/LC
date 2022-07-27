package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class codeforces1203D2{
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String s = sc.readLine();
        String t = sc.readLine();
        out.println(process(s,t));
        StringBuffer sb = new StringBuffer();
        out.close();
    }

    private static int process(String s, String t) {
        if (s.length()-t.length()<=1)return s.length()-t.length();
        char[] str = s.toCharArray();
        char[] tag = t.toCharArray();
        int ans = 0;
        int n = tag.length;
        int[] indexmin = new int[n];
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i]==tag[index]){
                indexmin[index] = i;
                index++;
            }
            if (index==n)break;
        }
        ans = str.length-1-indexmin[n-1];
        index = n-1;
        for (int i = str.length-1; i >=0; i--) {
            if (str[i]==tag[index]){
                if (index>0)ans = Math.max(ans,i-indexmin[index-1]-1);
                else ans = Math.max(ans,i);
                index--;
            }
            if (index<0)break;
        }
        return ans;
    }
}
