package com.bridgelabz;

public class MyNode<K> implements INode<K>{
    private INode next;
    private K key;

    public MyNode(K key) {
        this.key = key;
        this.next = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public void setKey() {
        this.key = key;
    }

    public INode getNext() {
        return next;
    }

    @Override
    public void set(INode next) {

    }

    public void setNext(INode next) {
        this.next = next;
    }
}
