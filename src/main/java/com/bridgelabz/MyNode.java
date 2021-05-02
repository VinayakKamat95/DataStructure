package com.bridgelabz;

public class MyNode<K> implements INode<K>{
    private INode next;
    private K key;

    public MyNode(K key) {
        this.key = key;
        this.next = null;
    }


    @Override
    public INode getNext() {
        return next;
    }

    @Override
    public void set(INode next) {

    }

    @Override
    public void setNext(INode next) {
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey() {

    }

    public void setKey(K key) {
        this.key = key;
    }

}
