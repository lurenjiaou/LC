package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codeforces1096D {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.valueOf(sc.readLine());
        char[] str = sc.readLine().toCharArray();
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int[] nums = new int[n];
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex,n);
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex,-1);
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
            firstIndex[str[i]-'a'] = Math.min(firstIndex[str[i]-'a'],i);
            lastIndex[str[i]-'a'] = i;
        }
        long ans = Long.MAX_VALUE;
        if (lastIndex['h'-'a']==-1||lastIndex[0]==-1||lastIndex['r'-'a']==-1||lastIndex['d'-'a']==-1){
            out.println(0);
            out.close();
            return;
        }
        lastIndex['r'-'a'] = Math.min(lastIndex['r'-'a'],lastIndex['d'-'a'] );
        lastIndex[0] = Math.min(lastIndex[0],lastIndex['r'-'a']);
        lastIndex['h'-'a'] = Math.min(lastIndex['h'-'a'],lastIndex[0] );
        firstIndex[0] = Math.max(firstIndex[0],firstIndex['h'-'a'] );
        firstIndex['r'-'a'] = Math.max(firstIndex['r'-'a'],firstIndex['d'-'a'] );
        //删除第一个‘a'之前所有h的代价
        long cost = 0L;
        for (int i = 0; i < lastIndex[0]; i++) {
            if (str[i]=='h')cost += nums[i];
        }
        ans = Math.min(ans,cost);
        //删除第一个‘h’之后到最后一个'r'之前的所有’a‘的代价
        cost = 0L;
        for (int i = firstIndex['h'-'a']; i < lastIndex['r'-'a']; i++) {
            if (str[i]=='a')cost += nums[i];
        }
        ans = Math.min(ans,cost);
        //删除第一个’a‘之后到最后一个’d‘之间的所有’r‘的代价
        cost = 0L;
        for (int i = firstIndex[0]; i < lastIndex['d'-'a']; i++) {
            if (str[i]=='r')cost +=nums[i];
        }
        ans = Math.min(ans,cost);
        //删除第一个‘r'之后所有的’d‘的代价
        cost = 0L;
        for (int i = firstIndex['r'-'a']; i < n; i++) {
            if (str[i]=='d')cost +=nums[i];
        }
        ans = Math.min(cost,ans);
        out.println(ans);
        out.close();
    }
}
