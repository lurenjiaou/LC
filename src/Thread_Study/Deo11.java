package Thread_Study;

import leetcode_07.A;

import java.util.Arrays;
import java.util.Comparator;

public class Deo11 {
    public static void main(String[] args) {
        int[][] nums = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        Integer[]num2 = {1,2,3};
        Arrays.sort(num2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Integer a = 2;
        System.out.println(a.getClass());
        System.out.println(new int[]{1,3,4}.getClass());
        System.out.println(num2.getClass());
        System.out.println(Arrays.toString(num2));
    }

    private static Integer process(int i, int i1) {
        return i+i1;
    }
}
