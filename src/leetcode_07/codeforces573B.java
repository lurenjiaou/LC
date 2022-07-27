package leetcode_07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class codeforces573B {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        int n = Integer.valueOf(s1);
        String[] nums_str = s2.split(" ");
        int[] nums = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(nums_str[i]);
            ans[i] = nums[i];
        }
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = Math.min(ans[i - 1] + 1, ans[i]);
        }
        ans[n - 1] = 1;
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.min(ans[i + 1] + 1, ans[i]);
            res = Math.max(ans[i], res);
        }
        HashSet<Integer> S = new HashSet<>();
        System.out.println(res);
    }
}
