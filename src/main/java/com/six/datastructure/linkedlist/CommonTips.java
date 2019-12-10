package main.java.com.six.datastructure.linkedlist;

/**
 * @author hellenxu
 * @date 2017-08-14
 * Copyright 2017 Six. All rights reserved.
 */
public class CommonTips {
    private static final SixNode a = new SixNode("a", null);
    private static final SixNode m = new SixNode("m", null);
    private static final SixNode c = new SixNode("c", null);
    private static final SixNode bb = new SixNode("bb", null);
    private static final SixNode dd = new SixNode("dd", c);

    public static void main (String[] args) {
        SixSingleLinkedList linkedList = new SixSingleLinkedList(a);
        linkedList.insertHead(m);
        linkedList.insert(1, c);
        linkedList.insert(3, bb);
        System.out.println(linkedList.toString());

        System.out.println("...start switching...");
        System.out.println(switchLinkedList(linkedList).toString());
        System.out.println("...end of switching...");

//        linkedList.insert(4, dd);
        System.out.println(linkedList.toString());

        System.out.println("...get node in the middle...");
        System.out.println(getMiddleNode(linkedList));
        System.out.println("...end...");

        System.out.println(linkedList.toString());
        System.out.println("...get node in last 3rd position...");
        System.out.println(getLastThirdNode(linkedList));
        System.out.println("...end...");
    }

    private static SixSingleLinkedList switchLinkedList(SixSingleLinkedList original) {
        SixNode currentNode;
        SixSingleLinkedList switchList = new SixSingleLinkedList();

        for(int i = 0; i < original.size(); i ++) {
            currentNode = original.getNode(i);
            if(currentNode != null) {
                switchList.insertHead(currentNode);
            }
        }
        return switchList;
    }

    private static SixNode getMiddleNode(SixSingleLinkedList list) {
        SixNode normalNode = list.getHead(), quickNode = list.getHead();
        while (quickNode != null && quickNode.next != null){
            quickNode = quickNode.next.next;
            normalNode = normalNode.next;
        }
        return normalNode;
    }

    private static SixNode getLastThirdNode(SixSingleLinkedList list) {
        SixNode target = list.getHead(), referenceNode = list.getHead();
        int count = 2;
        while (referenceNode != null && referenceNode.next != null){
            if(count > 0){
                count --;
            } else {
                target = target.next;
            }
            referenceNode = referenceNode.next;
        }
        return target;
    }
}
