package com.six.datastructure;

/**
 * @author hellenxu
 * @date 2017-08-04
 * Copyright 2017 Six. All rights reserved.
 */
class SixNode {
    Object value;
    SixNode next;

    SixNode(Object value, SixNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "value: " + value + ";; next: " + next;
    }
}
