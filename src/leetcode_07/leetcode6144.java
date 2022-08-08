package leetcode_07;

import java.util.Arrays;

public class leetcode6144 {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i]>nums[i+1]){
                int tmp = nums[i]%nums[i+1];
                if (tmp==0){
                    ans += nums[i]/nums[i+1]-1;
                    nums[i] = nums[i+1];
                }else {
                    int count = nums[i]/nums[i+1]+1;
                    ans += nums[i]/nums[i+1];
                    nums[i] = nums[i]/count;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode6144().minimumReplacement(new int[]{368,112,2,282,349,127,36,98}));
    }
}
