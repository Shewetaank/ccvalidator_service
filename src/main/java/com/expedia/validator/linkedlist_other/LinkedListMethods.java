package com.expedia.validator.linkedlist_other;

import javax.ws.rs.core.Link;

public class LinkedListMethods {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(4);

        linkedList.push(4, new Node(19));
        linkedList.push(3, new Node(12));

        LinkedList linkedList1 = copy(linkedList);
    }

    public static LinkedList copy(LinkedList linkedList) {
        return null;
    }
}
