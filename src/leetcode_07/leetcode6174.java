package leetcode_07;

import java.util.HashMap;

public class leetcode6174 {
    public long taskSchedulerII(int[] tasks, int space) {
        int n = tasks.length;
        long ans = 0;
        HashMap<Integer,Long> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long tmp = mp.getOrDefault(tasks[i],0L);
            if (ans>=tmp){
                ans++;
                mp.put(tasks[i],ans+space);
            }else {
                ans = tmp+1;
                mp.put(tasks[i],ans+space);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new leetcode6174().taskSchedulerII(new int[]{5,8,8,5},2));
    }
}
