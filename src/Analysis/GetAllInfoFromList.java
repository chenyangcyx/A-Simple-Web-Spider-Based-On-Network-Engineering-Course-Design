package Analysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//获取排行榜列表的所有信息
public class GetAllInfoFromList {
    String url_content;

    public GetAllInfoFromList(String content){
        this.url_content=content;
    }

    public void GetInfo(){
        GetAllMatchString(url_content,"<li>","</li>");

    }

    public void GetAllMatchString(String content,String start_str,String end_str){
        int last_start=0;
        String[] all_match=null;
        int count=0;
        while(content.indexOf(start_str,last_start)!=-1){
            last_start=content.indexOf(start_str,last_start);
            System.out.println(content.substring(content.indexOf(start_str,last_start),content.indexOf(end_str,last_start)));
            last_start++;
        }
    }
}