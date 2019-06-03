package com.expedia.validator.linkedlist;

public class LinkedList {

    public Node getNode() {
        return head;
    }

    public void setNode(Node node) {
        this.head = node;
    }

    private Node head;

    public LinkedList(int value) {
        this.head = new Node(value);
    }

    public int count() {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            i++;
            temp = temp.getNext();
        }
        return i;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.setNext(head);
        this.head = node;
    }
}
