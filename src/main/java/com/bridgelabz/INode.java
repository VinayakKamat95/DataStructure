package com.bridgelabz;

public interface INode<K> {
    K getKey();
    void setKey();

    INode<K> getNext();
    void set(INode next);
    void setNext(INode tempNode);

    void setKey(K key);
}
