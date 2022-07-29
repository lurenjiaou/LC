package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class codeforces175C {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.valueOf(sc.readLine());
        long[][] boss = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(sc.readLine());
            boss[i][0] = Long.valueOf(st.nextToken());
            boss[i][1] = Long.valueOf(st.nextToken());
        }
        int t = Integer.valueOf(sc.readLine());
        long[] nums = new long[t+1];
        StringTokenizer st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < t; i++) {
            nums[i+1] = Long.valueOf(st.nextToken());
        }
        Arrays.sort(boss, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[1]-o2[1]);
            }
        });
        long count = 0;
        long sum = 0;
        int indexb = 0;
        int indexn = 1;
        while (indexb<n&&indexn<t+1){
            long tmp = Math.min(boss[indexb][0],nums[indexn]-count);
            boss[indexb][0]-=tmp;
            count+=tmp;
            sum += boss[indexb][1]*indexn*tmp;
            if (boss[indexb][0]==0){
                indexb++;
            }
            if (count==nums[indexn]){
                indexn++;
            }
        }
        while (indexb<n){
            long tmp = boss[indexb][0];
            sum += boss[indexb][1]*indexn*tmp;
            indexb++;
        }
        out.println(sum);
        out.close();
    }
}
