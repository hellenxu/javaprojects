package com.six.datastructure.linkedlist;

/**
 * @author hellenxu
 * @date 2017-08-04
 * Copyright 2017 Six. All rights reserved.
 */
public class Demo {

    public static void main (String[] args) {
        SixNode head = new SixNode("a", null);
        SixSingleLinkedList linkedList = new SixSingleLinkedList(head);
        linkedList.insertHead(new SixNode("m", null));
        linkedList.insert(1, new SixNode("c", null));
        linkedList.insert(3, new SixNode("bb", null));
        System.out.println(linkedList.toString());

        linkedList.remove(0);
        linkedList.remove(1);
        System.out.println(linkedList.toString());

        SixNode node = linkedList.getNode(0);
        System.out.println(node.toString());

        linkedList.clean();
        System.out.println(linkedList.toString());
    }
}
