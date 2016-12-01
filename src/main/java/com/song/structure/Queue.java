package com.song.structure;

import java.util.LinkedList;

/**
 * Created by Song on 2016/11/29.
 * 待访问队列
 */
public class Queue {

    private LinkedList<Object> queue = new LinkedList<Object>();
    //入队列
    public void enUueue(Object t){
        queue.addLast(t);
    }
    //出队列
    public Object deQueue(){
        return queue.removeFirst();
    }
    //判断队列是否为空
    public boolean isQueueEmpty(){
        return queue.isEmpty();
    }
    //判断队列是否包含t
    public boolean contains(Object t){
        return queue.contains(t);
    }
}
