package leetcode_07;

public class leetcode1413 {
    public int minStartValue(int[] nums) {
        int ans = 1;
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            ans = Math.max(ans,1-presum);
        }
        return ans;
    }
}
