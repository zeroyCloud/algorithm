package com.cloudluo.stud.dataStruct;

/**
 * 单链表
 *
 * @author cloudluo
 */


public class SingleLinkedList<T> {

    private SingleLinkedNode<T> headNode;
    private SingleLinkedNode<T> tailNode;
    private int length;

    public SingleLinkedList(){
        length = 0;
    }

    public SingleLinkedList(SingleLinkedNode headNode){
        this.headNode = headNode;
        this.length = 0;
        SingleLinkedNode curNode = headNode;
        while(curNode.getNextNode() != null) {
            curNode = curNode.getNextNode();
            ++this.length;
        }
        this.tailNode = curNode;
        this.length++;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        SingleLinkedNode curNode = this.headNode;
        while(curNode != null){
            sb.append(curNode.getValue().toString());
            sb.append(",");
            curNode = curNode.getNextNode();
        }
        return sb.toString();
    }

    public int getLength(){
        return this.length;
    }

    public void addNode(T value){
        SingleLinkedNode<T> newPoint = new SingleLinkedNode<T>();
        newPoint.setValue(value);
        if(length == 0){
            headNode = newPoint;
            tailNode = newPoint;
        }else {
            tailNode.setNextNode(newPoint);
            tailNode = newPoint;
        }
        ++length;
    }

    public void insert(int index, T value){
        checkIndex(index);
        SingleLinkedNode curNode = localNode(index-1);
        SingleLinkedNode newNode = new SingleLinkedNode();
        newNode.setValue(value);
        newNode.setNextNode(curNode.getNextNode());
        curNode.setNextNode(newNode);
    }

    public void delete(int index){
        checkIndex(index);
        SingleLinkedNode curNode = localNode(index-1);
        SingleLinkedNode nextNode = curNode.getNextNode();
        curNode.setNextNode(nextNode.getNextNode());
        nextNode.setNextNode(null);
    }

    public Object getNode(int index){
        checkIndex(index);
        SingleLinkedNode curNode = localNode(index);
        return curNode.getValue();
    }

    public SingleLinkedList[] cutList(int index) {
        checkIndex(index);
        SingleLinkedNode singleLinkedNode = localNode(index-1);
        SingleLinkedNode nextHeadNode = singleLinkedNode.getNextNode();
        singleLinkedNode.setNextNode(null);
        this.tailNode = singleLinkedNode;
        this.length = index;
        SingleLinkedList[] slLists= {this, new SingleLinkedList<>(nextHeadNode)};
        return slLists;
    }

    public void reverseLinkedList() {
        if(length <= 1){
            System.out.println("need not reverse list");
            return;
        }
        SingleLinkedNode curNode = headNode;
        SingleLinkedNode nextNode = headNode.getNextNode();
        while(nextNode != null){
            SingleLinkedNode temp = nextNode.getNextNode();
            nextNode.setNextNode(curNode);
            curNode = nextNode;
            nextNode = temp;
        }
        SingleLinkedNode temp = headNode;
        headNode = tailNode;
        tailNode = temp;
        tailNode.setNextNode(null);
    }

    public SingleLinkedList foldLinkedList() {
        if(length <= 1){
            System.out.println("need not fold list");
            return this;
        }
        // 从中间切割链表
        int cutIndex = this.length / 2;
        if(this.length % 2 > 0){
            ++cutIndex;
        }
        SingleLinkedList[] singleLinkedLists = cutList(cutIndex);
        // 反转后半部分链表
        singleLinkedLists[1].reverseLinkedList();
        System.out.println(singleLinkedLists[0].toString());
        System.out.println(singleLinkedLists[1].toString());
        // 拼接两个链表
        SingleLinkedNode l1Node = singleLinkedLists[0].headNode;
        SingleLinkedNode l2Node = singleLinkedLists[1].headNode;
        while (l1Node != null && l2Node != null) {
            SingleLinkedNode temp1 = l1Node.getNextNode();
            SingleLinkedNode temp2 = l2Node.getNextNode();
            l1Node.setNextNode(l2Node);
            l2Node.setNextNode(temp1);
            l1Node = temp1;
            l2Node = temp2;
            ++this.length;
        }
        return new SingleLinkedList(this.headNode);
    }

    private void checkIndex(int index){
        if(index >= length){
            throw new IndexOutOfBoundsException();
        }
    }

    private SingleLinkedNode localNode(int index) {
        int i = 0;
        SingleLinkedNode curNode = headNode;
        while(i < index){
            curNode = curNode.getNextNode();
            ++i;
        }
        return curNode;
    }

}
