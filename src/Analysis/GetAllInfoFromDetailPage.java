package Analysis;
import DataProcess.FilmDetailData;
import DataProcess.OverAllData;

import java.util.LinkedList;

public class GetAllInfoFromDetailPage {
    OverAllData all=OverAllData.overall;

    String url_content;

    public GetAllInfoFromDetailPage(String url){
        this.url_content=url;
    }

    public void GetInfo(){
        String json=GetJsonContent(url_content);
        System.out.println(Get_title(json));
        System.out.println(Get_publish_date(json));
    }

    //获取网页内容的json数据
    public String GetJsonContent(String content){
        return content.substring(content.indexOf(all.FILMDETAIL_JSON_START)+all.FILMDETAIL_JSON_START.length(),
                content.indexOf(all.FILMDETAIL_JSON_END,content.indexOf(all.FILMDETAIL_JSON_START)));
    }

    //获取电影标题
    public String Get_title(String json){
        return json.substring(json.indexOf(all.FILMDETAIL_TITLE_START)+all.FILMDETAIL_TITLE_START.length(),
                json.indexOf(all.FILMDETAIL_TITLE_END,json.indexOf(all.FILMDETAIL_TITLE_START)))
                .replace("\"","");
    }

    //获取电影发行日期
    public String Get_publish_date(String json){
        return json.substring(json.indexOf(all.FILMDETAIL_PUBLISH_DATE_START)+all.FILMDETAIL_PUBLISH_DATE_START.length(),
                json.indexOf(all.FILMDETAIL_PUBLISH_DATE_END,json.indexOf(all.FILMDETAIL_PUBLISH_DATE_START)))
                .replace("\"","");
    }

    //获取电影的导演信息
    public String Get_director(String json){
        if(json.contains(all.FILMDETAIL_DIRECTOR_START1)){

        }
        else
            return "";
    }
}
