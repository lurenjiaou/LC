package leetcode_07;

import java.util.HashMap;

public class leetcode1915 {
    public long wonderfulSubstrings(String word) {
        long ans = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int cur = 0;
        char[] str = word.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int tmp = 1<<(str[i]-'a');
            cur = cur^tmp;
            mp.put(cur,mp.getOrDefault(cur,0)+1);
        }
        cur = 0;
        for (int i = 0; i < str.length; i++) {
            mp.put(cur,mp.getOrDefault(cur,0)-1);
            ans += mp.getOrDefault(cur,0);
            for (int j = 0; j < 26; j++) {
                int tmp = 1<<j;
                ans += mp.getOrDefault(cur^tmp,0);
            }
            int tmp = 1<<(str[i]-'a');
            cur = cur^tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode1915().wonderfulSubstrings("aabb"));
    }
}
