package com.mytest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixi  on 2019/3/4
 */
public class OutOfMemoryErrorTest {

    public static void main(String[] args) {
        String name = "hello";
//        for (int i = 0; i < 10000000; i++) {
//            name += name;
//        }
//        System.out.println(name);

        int [] nums = {4,3,2,7,8,2,3,1};
        OutOfMemoryErrorTest ss = new OutOfMemoryErrorTest();
        ss.findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {

            int index =Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index]=-nums[index];

        }
        List<Integer> list = new ArrayList<Integer>();
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]>0)
                list.add(j+1);
        }
        return list;
    }
}
