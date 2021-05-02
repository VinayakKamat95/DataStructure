package com.bridgelabz;


public class MyLinkedList<T>  {
    private int size;
    public INode<T> tail;
    public INode<T> head;

    public MyLinkedList() {
        size = 0;
        this.head = null;
        this.tail = null;
    }

    //printMyNodes() will display size of the linked list
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

    //add() will insert node after node in the linked list
    public void add(INode<T> newNode) {
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

    //append() will insert node before node in the linked list
    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
        size++;
    }

    //insert() will insert node in the linked list given node at which need to insert and new Node
    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
        size++;
    }

    //popLast() will delete head nodes from the linked list
    public void popHead() {
        this.head = head.getNext();
        size--;
    }

    //popLast() will delete tail nodes from the linked list
    public void popTail() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode.setNext(null);
        size--;
    }

    //search() will search nodes from the linked list on given key value(Data) returns Node
    public INode search(T key) {
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    //delete() will delete nodes from the linked list
    public void delete(INode delNode) {
        INode tempNode = head;
        INode prevNode = null;
        if (tempNode.getKey().equals(delNode.getKey())) {
            popHead();
            return;
        }
        while (tempNode.getNext() != null) {
            if (tempNode.getKey().equals(delNode.getKey())) {
                prevNode.setNext(tempNode.getNext());
                size--;
                return;
            }
            prevNode = tempNode;
            tempNode = tempNode.getNext();
        }
        popTail();
    }

    //size() will display size of the linked list
    public void size() {
        System.out.println(size);
    }

    //sortList() will sort nodes of the list in ascending order
    public <K extends Comparable<K>> void sortAscendList() {
        //Node current will point to head
        //Node index will point to next of head
        INode<K> current = (INode<K>) head, index;
        K temp = null;
        if (head == null) {
            return;
        } else {
            while (current.getNext() != null) {
                index = current.getNext();

                while (index.getNext() != null) {
                    if (current.getKey().compareTo(index.getKey()) > 0) {
                        temp = current.getKey();
                        current.setKey(index.getKey());
                        index.setKey(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }
}