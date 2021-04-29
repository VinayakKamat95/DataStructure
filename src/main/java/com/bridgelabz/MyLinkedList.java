package com.bridgelabz;

public class MyLinkedList {
    public INode tail;
    public INode head;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public void printMyNodes(){
        StringBuffer myNodes = new StringBuffer("My Nodes : ");
        INode tempNode = head;
        while(tempNode.getNext() != null){
            myNodes.append(tempNode.getKey());
            if(!tempNode.equals(tail))
                myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    public void add(INode<Integer> newNode) {
        if(this.head == null){
            this.head = newNode;
        }
        if(this.tail == null){
            this.tail = newNode;
        }else{
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(INode myNode) {
        if(this.head == null){
            this.head = myNode;
        }
        if(this.tail == null){
            this.tail = myNode;
        }else{
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode popHead(){
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLast(){
        INode tempNode = head;
        while(!tempNode.getNext().equals(tail)){
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }
}
