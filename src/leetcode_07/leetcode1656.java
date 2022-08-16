package leetcode_07;

import java.util.ArrayList;
import java.util.List;

public class leetcode1656 {
    private String[] stream;
    private int ptr;
    private int end;
    private List<String> ans;
    public void OrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
        end = -1;
        ans = new ArrayList<>();
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey-1] = value;
        if (ans.size()>end-ptr+1)ans = new ArrayList<>();
        while (end+1<stream.length&&stream[end+1]!=null) {
            ans.add(stream[end+1]);
            end++;
        }
        for (int i = ptr; i <= end; i++) {
            ans.add(stream[i]);
        }
        if(ans.size()>0)ptr=end+1;
        return ans;
    }
    public static void main(String[] args) {

    }
}
