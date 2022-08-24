package test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class problem2 {
    public int minMax (ArrayList<Integer> a, int k, int x) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int key:a) {
            q.add(key);
        }
        for (int i = 0; i < k; i++) {
            int  tmp = q.poll();
            tmp -=x;
            q.add(tmp);
        }
        return q.peek();
    }
}
