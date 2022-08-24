package test1;

public class problem6 {
    public int howMany (String s, int k) {
        // write code here
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        int ans =0;
        for (int i = 0; i < 26; i++) {
            if (count[i]>=k)ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
