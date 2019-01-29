package com.cloudluo.stud.algorithm.string;

/**
 * @author: cloud.luo
 * @date: 2019/1/18 13:27
 * @func: 输入字符串s和行数numRows, 返回Z字型排序
 */
public class ZSort {
    public static void main(String args[]){
        String result = convert("PAYPALISHIRING", 3);
        System.out.print(result);
    }

    public static String convert(String s, int numRows) {
        char[] schar = s.toCharArray();
        schar = new char[]{};
        int len = s.length();
        int groupSize = 2*numRows-2;
        int numCols;
        if(len%groupSize > numRows){
            numCols = len/groupSize*(numRows-1)+1+(len%groupSize%numRows);
        }else{
            numCols = len/groupSize*(numRows-1)+1;
        }
        char[][] zchar = new char[numRows][numCols];
        int rowIndex = 0;
        int colIndex = 0;

        for(char c : schar){
            zchar[rowIndex][colIndex] = c;
            if(colIndex%(numRows-1) == 0 && rowIndex < numRows-1){
                rowIndex++;
            }else{
                rowIndex--;
                colIndex++;
            }
        }

        String result = "";
        for(int i=0; i<numRows; i++){
            result = result.concat(String.valueOf(zchar[i]));
        }
        result.replaceAll("\\u0000","");
        return result;
    }

}
