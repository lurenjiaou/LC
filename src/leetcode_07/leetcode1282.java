package leetcode_07;

import java.util.ArrayList;
import java.util.List;

public class leetcode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer>[] mp = new List[600];
        for (int i = 0; i < groupSizes.length; i++) {
            if (mp[groupSizes[i]]==null)mp[groupSizes[i]] = new ArrayList<>();
            mp[groupSizes[i]].add(i);
            if (mp[groupSizes[i]].size()==groupSizes[i]) {
                ans.add(mp[groupSizes[i]]);
                mp[groupSizes[i]] = new ArrayList<>();
            }
        }
        return ans;
    }
}
