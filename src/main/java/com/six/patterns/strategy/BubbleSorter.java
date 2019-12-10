package main.java.com.six.patterns.strategy;

/**
 * @author hellenxu
 * @date 2017-08-15
 * Copyright 2017 Six. All rights reserved.
 */
public class BubbleSorter {
    private int length = 0;
    private SortHandler sortHandler = null;

    public BubbleSorter(SortHandler handler){
        this.sortHandler = handler;
        length = handler.getLength();
    }

    public int sort(){
        int operations = 0;
        if(length <= 1) {
            return operations;
        }

        for(int next2Last = length - 2; next2Last >= 0; next2Last --) {
            for(int index = 0; index <= next2Last; index ++) {
                if(sortHandler.outOfOrder(index)) {
                    sortHandler.swap(index);
                }
                operations++;
            }
        }
        
        return operations;
    }
}
