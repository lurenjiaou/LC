package leetcode_07;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode898 {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> st = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> curst = new HashSet<>();
            for(int key: st){
                curst.add(key|arr[i]);
                ans.add(key|arr[i]);
            }
            curst.add(arr[i]);
            ans.add(arr[i]);
            st = curst;
        }
        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(new leetcode898().subarrayBitwiseORs(new int[]{1,2,4,5}));
    }
}
