package leetcode_07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;


public class Test
{
    public static Test t1 = new Test();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String args[])throws InterruptedException{

        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(609);
        System.out.println(set+" "+subSet);

    }

    private static void process(String a,String b) {
        System.out.println(a==b);
    }

}
