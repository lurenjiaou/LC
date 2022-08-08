package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class codeforces808D {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.valueOf(sc.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(sc.readLine());
        long sum = 0;
        HashMap<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = Long.valueOf(st.nextToken());
            sum += a[i];
            mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
        }
        if (sum % 2 == 1) {
            out.println("NO");
            out.close();
            return;
        }
        HashMap<Long, Integer> mp2 = new HashMap<>();
        long target = sum / 2,cur = 0;
        for (int i = 0; i < n; i++) {
            if (mp.getOrDefault(target - cur, 0) >= 1 || mp2.getOrDefault(cur - target, 0) >= 1) {
                out.println("YES");
                out.close();
                return;
            }
            cur += a[i];
            mp2.put(a[i], mp2.getOrDefault(a[i], 0) + 1);
            mp.put(a[i], mp.get(a[i]) - 1);
        }
        out.println("NO");
        out.close();
    }
}
