package com.cloudluo.stud.comm.utils;

import java.util.Scanner;

public class InOutUtils {

    public static String userInput(String note) {
        System.out.println(note);
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return str;
    }
}
