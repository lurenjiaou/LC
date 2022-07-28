package leetcode_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class codeforces1281B {
    public static void main(String[] args) throws IOException {
        final BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.valueOf(sc.readLine());
        while (n>0){
            StringTokenizer st = new StringTokenizer(sc.readLine());
            String s = st.nextToken();
            String t = st.nextToken();
            String ans =  process(s,t);
            out.println(ans);
            n--;
        }
        out.close();
    }

    private static String process(String s, String t) {
        char[] str = s.toCharArray();
        char[] tar = t.toCharArray();
        int[] index = new int[26];
        for (int i = 0; i < str.length; i++) {
            index[str[i]-'A'] = i;
        }
        int chance = 1;

        for (int i = 0; i < str.length&&i<tar.length; i++) {
            //直接返回
            if (str[i]-'A'<tar[i]-'A'){
                return new String(str);
            }else if (str[i]==tar[i]){
                if (chance>0){
                    for (int j = 0; j < tar[i]-'A'; j++) {
                        //交换并返回
                        if (index[j]>i){
                            str[index[j]] = str[i];
                            str[i] = (char)('A'+j);
                            return new String(str);
                        }
                    }
                }
            }else {
                if (chance>0){
                    for (int j = 0; j < tar[i]-'A'; j++) {
                        //交换并返回
                        if (index[j]>i){
                            str[index[j]] = str[i];
                            str[i] = (char)('A'+j);
                            return new String(str);
                        }
                    }
                    if (index[tar[i]-'A']>i){
                        chance--;
                        str[index[tar[i]-'A']] = str[i];
                        str[i] = tar[i];
                    }else {
                        return "---"; 
                    }
                }else {
                    return "---";
                }
            }
        }
        if (str.length< tar.length)return new String(str);
        return "---";
    }
}
