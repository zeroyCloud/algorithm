package com.cloudluo.stud.algorithm.math;

import com.cloudluo.stud.comm.utils.InOutUtils;

public class clockSpiralMatrix {

    public static void main(String[] args) {
        clockMatrix();
    }

    public static void clockMatrix() {
        // input
        String num = InOutUtils.userInput("请输入矩阵阶数");
        // transfer int
        Integer n = null;
        try{
            n = Integer.valueOf(num);
        }catch(Exception ex){
            System.out.println("please input number!");
            ex.printStackTrace();
        }
        // 二維數組xy下標
        int ix = 0, iy = 0;
        // 二維數組前進步長（0,1,-1）
        int px = 1, py = 0;
        // 該行/列前進總長
        int tots = n;
        // 該行/列已走步數
        int hs = 0;
        int[][] cmat = new int[n][n];
        for(int i=1; i<=n*n; i++){
            cmat[iy][ix] = i;
            hs++;
            if(tots == hs){
                hs = 0;
                // 边走完减总路程
                if(px != 0){
                    tots = tots- 1;
                }
                int ls = py;
                py=px;
                px=(-1)*ls;
            }
            // 定位下次坐標
            ix = ix + px;
            iy = iy + py;
        }
        // print
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(cmat[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
