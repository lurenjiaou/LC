package leetcode_07;

import java.util.Stack;

public class leetcode1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer>s = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!s.empty()&&prices[s.peek()]>=prices[i]){
                int tmp = s.pop();
                prices[tmp] -= prices[i];
            }
            s.add(i);
        }
        return prices;
    }
}
