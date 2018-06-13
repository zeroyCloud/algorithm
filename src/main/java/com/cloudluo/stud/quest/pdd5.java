package com.cloudluo.stud.quest;

import com.cloudluo.stud.comm.utils.InOutUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CloudLuo on 2017/4/16.
 */
public class pdd5 {

    public static void main(String args[]){
        least2d1s();
    }

    /**
     * 问题：
     * 输入一个数组A，数组里的数均为正整数，可以对数组做如下操作：
     * 1. 单独一个数+1
     * 2. 所有数组乘以2
     * 给定一个数组B，与数组A等长，且每个数均均为1，
     * 请问最少执行多少步操作，可以将A变为数组B
     */
    public static void least2d1s() {
        while(true) {
            // 输入数组
            String str = InOutUtils.userInput("请输入数组，以逗号隔开：");
            List<Integer> num = new ArrayList<>();
            try {
                String strs[] = str.replaceAll(" ", "").split(",");
                for(String st : strs){
                    num.add(Integer.valueOf(st));
                }
            } catch (Exception ex) {
                System.out.println("请输入正确的数字，并以逗号（“,”半角）隔开");
                ex.printStackTrace();
            }
            // 找出最小数，放在最后一位

            // 根据最小值计算翻倍次数(最小数在最后一位) num.get(num.size()-1)
            int doubleTime = colMinDouble(num.get(0));
            // 根据翻倍次数，每一个数执行加一的次数，并求和
            int sum = 0;
            List<Integer> stepNums = new ArrayList<>();
            for(Integer i : num){
                Integer stepNum = colMinStep4EveryNum(i, doubleTime);
                stepNums.add(stepNum);
                sum = sum + stepNum;
            }
            sum = sum + doubleTime;
            // 打印结果
            for(int i=0; i<num.size(); i++){
                System.out.print(num.get(i)+" ");
            }
            System.out.println("");
            for(int i=0; i<stepNums.size(); i++){
                System.out.print(stepNums.get(i)+" ");
            }
            System.out.println("");
            System.out.println("最少执行次数：" + sum + "，执行翻倍的次数：" + doubleTime);
            System.out.println("");
        }
    }

    // 计算最小双倍数
    public static int colMinDouble(int minNum) {
        int dout = 0;
        int mindou = 1;
        while(mindou <= minNum){
            if(mindou <= minNum && mindou*2 > minNum){
                break;
            }else{
                mindou = mindou*2;
                dout = dout+1;
            }
        }
        return dout;
    }

    // 计算每个数所需最小+1次数
    public static int colMinStep4EveryNum(int num, int minDouble) {
        int sumStep = 0;
        int leaNum = num-(1 << minDouble);
        for(int i=minDouble; i>=0; i--){
            int step = 1 << i;
            int stepNu = 0;
            while(true){
                if(leaNum >= (stepNu * step) && leaNum < (stepNu+1) * step){
                    sumStep = sumStep + stepNu;
                    leaNum = leaNum - (stepNu*step);
                    break;
                }else{
                    stepNu++;
                }
            }
        }
        return sumStep;
    }

}
