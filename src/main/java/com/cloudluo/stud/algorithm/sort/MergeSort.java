package com.cloudluo.stud.algorithm.sort;

import java.util.Random;

/**
 * @author: cloud.luo
 * @date: 2019/1/18 13:27
 */
public class MergeSort {
    public static void main(String args[]){
        int[] nums = new int[50];
        Random random = new Random();
        System.out.print("origin nums: ");
        for(int i=0; i<50; i++){
            nums[i] = random.nextInt(100);
            System.out.print(nums[i]+", ");
        }
        System.out.println("");
        nums = sort(nums);
        System.out.print("sorted nums: ");
        for(int i=0; i<50; i++){
            System.out.print(nums[i]+", ");
        }
    }

    public static int[] sort(int[] nums){
        int length = nums.length;
        if(length > 2){
            int[] fi = new int[length/2];
            int[] sec = new int[length-(length/2)];
            for(int i=0; i<length/2; i++){
                fi[i] = nums[i];
            }
            for(int i=0; i<length-(length/2); i++){
                sec[i] = nums[i+length/2];
            }
            fi = sort(fi);
            sec = sort(sec);
            nums = mergeNums(fi, sec);
        }else if(length == 2){
            if(nums[0] > nums[1]){
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
        }
        return nums;
    }

    public static int[] mergeNums(int[] fiNum, int[] secNum) {
        int fiIndex = 0;
        int secIndex = 0;
        int mergeIndex = 0;
        int[] mergeNum = new int[fiNum.length + secNum.length];
        while(fiIndex < fiNum.length && secIndex < secNum.length){
            if(secIndex >= secNum.length || fiNum[fiIndex] < secNum[secIndex]){
                mergeNum[mergeIndex] = fiNum[fiIndex];
                fiIndex++;
            }else if(fiIndex >= fiNum.length || fiNum[fiIndex] >= secNum[secIndex]){
                mergeNum[mergeIndex] = secNum[secIndex];
                secIndex++;
            }
            mergeIndex++;
        }
        if(secIndex >= secNum.length){
            while(mergeIndex < mergeNum.length) {
                mergeNum[mergeIndex] = fiNum[fiIndex];
                fiIndex++;
                mergeIndex++;
            }
        }else if(fiIndex >= fiNum.length){
            while(mergeIndex < mergeNum.length) {
                mergeNum[mergeIndex] = secNum[secIndex];
                secIndex++;
                mergeIndex++;
            }
        }
        return mergeNum;
    }

}
