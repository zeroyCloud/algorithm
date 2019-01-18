package com.cloudluo.stud.dataStruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhiyun.luo
 * @date: 2018/12/18 10:53
 */
public class subSet {

    public static void main(String args[]) {
        int[] nums = new int[]{1,2};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println("finish");
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            List<Integer> nullset = new ArrayList<>();
            subset.add(nullset);
        } else {
            int head = nums[nums.length - 1];
            System.out.println("header:" + head);
            int[] restnums = new int[nums.length - 1];
            for (int i = 0; i < restnums.length; i++) {
                restnums[i] = nums[i];
            }
            List<List<Integer>> restsubset = subsets(restnums);
            //subset.addAll(restsubset);
            List<List<Integer>> restsubset2 = restsubset;
            for (List<Integer> rss : restsubset2) {
                subset.add(rss);
                List<Integer> rssh = new ArrayList<>();
                for (Integer s : rss) {
                    rssh.add(s);
                }
                rssh.add(head);
                subset.add(rssh);
            }

        }
        return subset;
    }


}
