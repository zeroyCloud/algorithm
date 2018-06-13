package com.cloudluo.stud.algorithm.eightQueen;

public class eightQueen {

    private static int[] curma = new int[8];

    private static int sum = 0;

    public static void main(String[] args) {
        queen8();
    }

    public static void queen8() {
        sonCyc(0);
        System.out.println("result: "+sum);
    }

    public static void sonCyc(int i) {
        if(i>=8){
            sum = sum+1;
            for(int cm : curma) {
                System.out.print(cm + " ");
            }
            System.out.println();
            return;
        }
        for(int value=0; value<8; value++) {
            if (judge(i, value)) {
                curma[i] = value;
                sonCyc(i + 1);
                curma[i] = 0;
            }
        }
    }

    public static boolean judge(int index, int value) {
        for(int i=0; i<index; i++){
            if(curma[i] == value || curma[i]+i == index+value
                    || curma[i]-i == value-index){
                return false;
            }
        }
        return true;
    }

}
