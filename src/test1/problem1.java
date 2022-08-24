package test1;

public class problem1 {
    public int minCnt (String s) {
        // write code here
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1')count++;
        }
        return count-1;
    }
}
