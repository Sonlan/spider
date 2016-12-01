package com.song.utils;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.LinkRegexFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Song on 2016/12/1.
 * 链接解析工具类
 */
public final class HtmlParserTool {

    public static Set<String> extractLinks(String url, LinkRegexFilter filter){
        Set<String> links = new HashSet<String>();
        try{
            Parser parser = new Parser(url);  //1
            parser.setEncoding("utf-8");
            NodeFilter nodeFilter = new NodeFilter() {
                public boolean accept(Node node) {
                    if(node.getText().startsWith("frame src=")){
                        return true;
                    }else return false;
                }
            };

            OrFilter orFilter = new OrFilter(new NodeClassFilter(LinkTag.class),nodeFilter);

            NodeList nodeList = parser.extractAllNodesThatMatch(orFilter);

            for(int i=0;i<nodeList.size();i++){
                Node tag = nodeList.elementAt(i);
                if(tag instanceof LinkTag){
                    if(filter.accept(tag)) links.add(((LinkTag) tag).getLink());
                }else {
                    String frame = tag.getText();
                    int start = frame.indexOf("src=");
                    frame = frame.substring(start);
                    int end = frame.indexOf(" ");
                    if(end == -1){
                        end = frame.indexOf(">");
                    }
                    String frameUrl = frame.substring(5,end-1);
                    if(filter.accept(tag)){
                        links.add(frameUrl);
                    }
                }
            }
        }catch (ParserException e){//1
            e.printStackTrace();
        }
        return links;
    }
}
