package com.expedia.validator.linkedlist_other;

public class LinkedList {

    Node head;

    public LinkedList(int value) {
        head.data = value;
        head.next = null;
        head.other = null;
    }

    public void push(int value, Node other) {
        Node node = new Node(value);
        node.next = head;
        node.other = other;
    }
}
