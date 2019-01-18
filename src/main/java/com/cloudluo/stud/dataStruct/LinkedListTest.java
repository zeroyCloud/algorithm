package com.cloudluo.stud.dataStruct;

import java.util.Random;

public class LinkedListTest {

    public static void main(String args[]){
        SingleLinkedList singleLinkedList = initRandomStrList(15);
        System.out.println("原本的list：" + singleLinkedList.toString());
        singleLinkedList.reverseLinkedList();
        System.out.println("反转的list：" + singleLinkedList.toString());
        singleLinkedList.foldLinkedList();
        System.out.println("折叠的list：" + singleLinkedList.toString());
    }

    public static SingleLinkedList initRandomStrList(int size) {
        SingleLinkedList<String> slList = new SingleLinkedList<>();
        int i = 0;
        Random random = new Random(System.currentTimeMillis());
        while (i < size){
            Integer rn = random.nextInt(100);
            slList.addNode(rn.toString());
            ++i;
        }
        return slList;
    }

}
