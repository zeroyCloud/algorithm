package com.cloudluo.stud.dataStruct;

public class SingleLinkedNode<T> {

    private SingleLinkedNode nextNode;
    private T value;

    public SingleLinkedNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(SingleLinkedNode nextNode) {
        this.nextNode = nextNode;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
