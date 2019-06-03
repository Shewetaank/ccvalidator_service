package com.expedia.validator.linkedlist;

public class LinkedListMethods {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(2);
        linkedList.push(4);
        linkedList.push(10);
        linkedList.push(12);

        System.out.println(linkedList.count());

    }
}
