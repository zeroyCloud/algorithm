package com.cloudluo.stud.algorithm.math;

import com.cloudluo.stud.comm.utils.InOutUtils;

/**
 * Created by CloudLuo on 2017/4/16.
 */
public class uglyNum {

    public static void main(String args[]){
        isUglyNumber();
    }

    public static void isUglyNumber() {
        while(true) {
            // 输入数字
            String str = InOutUtils.userInput("请输入数字：");
            Integer num = null;
            try {
                num = Integer.valueOf(str);
            } catch (Exception ex) {
                System.out.println("请输入正确的数字");
                ex.printStackTrace();
            }
            // 判断标志位
            Boolean isUgly = false;
            // 丑数判断
            if (num > 1) {
                while (num > 0) {
                    if (num % 2 != 0) {
                        if (num % 3 != 0) {
                            if (num % 5 != 0) {
                                if (num == 1) {
                                    isUgly = true;
                                }
                                break;
                            } else {
                                num = num / 5;
                            }
                        } else {
                            num = num / 3;
                        }
                    } else {
                        num = num / 2;
                    }
                }
            }

            // 打印结果
            if (isUgly) {
                System.out.println("Yes! 数字" + str + "是丑数");
            } else {
                System.out.println("No! 数字" + str + "不是丑数");
            }
            System.out.println("");
        }
    }


}
