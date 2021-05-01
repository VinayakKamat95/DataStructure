package com.bridgelabz;


public class MyLinkedList<K>{
    private int size;
    public INode<K> tail;
    public INode<K> head;

    public MyLinkedList() {
        size = 0;
        this.head = null;
        this.tail = null;
    }


    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes : ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail))
                myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    public void add(INode<K> newNode) {
        if (this.head == null) {
            this.head = newNode;
        }
        if (this.tail == null) {
            this.tail = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);

        }
        size++;
    }

    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;

        }size++;
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
        size++;
    }

    public void popHead() {
        this.head = head.getNext();
        size--;
    }

    public void popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode.setNext(null);
        size--;
    }

    public INode search(K key){
        INode tempNode = head;
        while(tempNode.getNext() != null){
            if(tempNode.getKey().equals(key)){return tempNode;}
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public void delete(INode delNode)
    {
        INode tempNode = head;
        INode prevNode = null;
        if(tempNode.getKey().equals(delNode.getKey())){
            popHead();
            return;
        }
        while(tempNode.getNext() != null){
            if(tempNode.getKey().equals(delNode.getKey()))
            {
                prevNode.setNext(tempNode.getNext());
                size--;
                return;
            }
            prevNode = tempNode;
            tempNode = tempNode.getNext();

        }
        popLast();
    }
    public void size(){
        System.out.println(size);
    }
}

