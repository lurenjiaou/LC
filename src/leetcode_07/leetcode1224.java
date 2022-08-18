package leetcode_07;

public class leetcode1224 {
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;
        //数字的频率
        int[] f = new int[100005];
        //数字的频率的频率
        int[] f_f = new int[100005];
        int ans = 2;
        //统计前缀出现了多少个数字
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (f[nums[i]]==0)count++;
            f_f[f[nums[i]]]--;
            f[nums[i]]++;
            f_f[f[nums[i]]]++;
            //情况1，count = i+1,或者count=1,直接删;
            if (count==i+1||count==1)ans = i+1;
            //情况2,前缀有count-1个数频率相同，有1个数频率为1
            if (count>1&&i%(count-1)==0&&f_f[1]==1&&f_f[i/(count-1)]==count-1)ans = i+1;
            //情况3,前缀有count-1个数频率相同频率为a,有一个数频率为a+1
            if (count>1&&i%count==0&&f_f[i/count]==count-1)ans = i+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new leetcode1224().maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
    }
}
