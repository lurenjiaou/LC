package leetcode_07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class codeforce1108E {
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }
        int[][] lr = new int[m][2];
        HashMap<int[],Integer> mp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            lr[i][0] = Integer.valueOf(st.nextToken())-1;
            lr[i][1] = Integer.valueOf(st.nextToken())-1;
            mp.put(lr[i],i+1);
        }
        Arrays.sort(lr, (o1, o2) -> {
            if (o1[0]==o2[0])return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        PriorityQueue<int[]>plan = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        PriorityQueue<int[]>q = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int index = 0;
        int ans = process(nums);
        for (int i = 0; i < n; i++) {
            //出队
            boolean flag = false;
            while (!q.isEmpty()&&q.peek()[1]<i){
                int[] tmp = q.poll();
                process2(nums,tmp,1);
            }
            while (index<m&&lr[index][0]<=i&&lr[index][1]>=i){
                process2(nums,lr[index],-1);
                q.add(lr[index]);
                index++;
                flag = true;
            }
            if (flag){
                int tmp = process(nums);
                if (tmp > ans) {
                    ans = tmp;
                    plan = new PriorityQueue<>(q);
                }
            }
        }
        int[] res = new int[plan.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mp.get(plan.poll());
        }
        out.println(ans);
        out.println(res.length);
        if (res.length==0){
            out.println();
            out.close();
            return;
        }
        for (int i = 0; i < res.length; i++) {
            out.print(res[i]+" ");
        }
        out.close();
    }

    private static void process2(int[] nums, int[] tmp, int k) {
        for (int i = tmp[0]; i <=tmp[1]; i++) {
            nums[i]+=k;
        }
    }

    private static int process(int[] nums) {
        int maxnum = nums[0],minnum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxnum = Math.max(nums[i],maxnum);
            minnum = Math.min(nums[i],minnum);
        }
        return maxnum-minnum;
    }
}
