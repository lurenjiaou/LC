package leetcode_07;

import java.util.Arrays;

public class leetcode2370 {
    public int longestIdealString(String s, int k) {
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int ans = 0;
        int n = str.length;
        for (int i = 0; i < n; i++) {
            count[str[i]-'a'] +=1;
            for (int j = 1; j <=k&&str[i]-'a'-j>=0; j++) {
                count[str[i]-'a'] = Math.max(count[str[i]-'a'],count[str[i]-'a'-j]+1);
            }
            for (int j = 1; j <=k&&str[i]-'a'+j<26; j++) {
                count[str[i]-'a'] = Math.max(count[str[i]-'a'],count[str[i]-'a'+j]+1);
            }
            ans = Math.max(ans,count[str[i]-'a']);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new leetcode2370().longestIdealString("acfgbd",2));
    }
}
