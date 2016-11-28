package com.song;

import com.song.utils.NetUtil;

/**
 * Created by Song on 2016/11/28.
 */
public class main {
    public static void main(String [] args){
        //String url = "http://1u5186s163.51mypc.cn/yzx/test/remote";
        String url = "http://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=index&fr=&hs=0&sf=1&fmq=&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word=星空&oq=星空&rsp=-1";
        //System.out.println(NetUtil.post(url,null));
        NetUtil.getPageHtml(url,null);
    }
}
