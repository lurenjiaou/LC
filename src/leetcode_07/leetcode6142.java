package leetcode_07;

import java.util.HashMap;

public class leetcode6142 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i]-=i;
        }
        long ans =0;
        mp.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            int count = mp.getOrDefault(nums[i],0);
            ans += (i-count);
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode6142().countBadPairs(new int[]{4,1,3,3}));
    }
}
