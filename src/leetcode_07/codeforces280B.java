package leetcode_07;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class codeforces280B {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = Integer.valueOf(sc.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        int ans = a[0]^a[1];
        for (int i = 0; i < n; i++) {
            while (!s.empty()&&a[s.peek()]<a[i])ans = Math.max(ans,a[s.pop()]^a[i]);
            if (!s.empty())ans = Math.max(ans,a[s.peek()]^a[i]);
            s.push(i);
        }
        while (!s.empty()){
            int tmp = a[s.pop()];
            if (!s.empty())ans = Math.max(ans,tmp^a[s.peek()]);
        }
        out.println(ans);
        out.close();
    }
}
