package com.song.structure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Song on 2016/11/29.
 */
public class LinkQueue {
    //已访问的URL集合
    private static Set visitedUrl = new HashSet();
    //待访问的URL集合
    private static Queue unVisitedUrl = new Queue();

    //获得URL队列
    public static Queue getUnVisitedUrl(){
        return unVisitedUrl;
    }
    //添加至访问过的Set中
    public static void addVisitedUrl(String url){
        visitedUrl.add(url);
    }
    //移除访问过的URL
    public static void removeVisitedUrl(String url){
        visitedUrl.remove(url);
    }
    //未访问过的队列出队列
    public static Object unVisitedUrlDeQueue(){
        return unVisitedUrl.deQueue();
    }
    //添加到未访问的队列中
    public static void addUnVisitedUrl(String url){
        if(null != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.contains(url)){
            unVisitedUrl.enUueue(url);
        }
    }

    //获得已经访问的URL数目
    public static int getVisitedUrlNum(){
        return visitedUrl.size();
    }

    //判断未访问的URL队列是否为空
    public static boolean unVisitedUrlisEmpty(){
        return unVisitedUrl.isQueueEmpty();
    }
}
