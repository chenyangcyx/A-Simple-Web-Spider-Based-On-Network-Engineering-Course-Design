package Analysis;
import DataDefinition.FilmDetailData;
import DataDefinition.OverAllData;
import java.util.LinkedList;

public class GetAllInfoFromDetailPage {
    private OverAllData all=OverAllData.overall;
    private UnicodeDecode ud=new UnicodeDecode();

    private String url_content;

    public GetAllInfoFromDetailPage(String content){
        this.url_content=content;
    }

    public FilmDetailData GetInfo(){
        String json=GetJsonContent(url_content);
        FilmDetailData fdd=new FilmDetailData();
        //检查特定的内容
        if(url_content.contains("发条橙")||url_content.contains("国王的演讲"))
            return fdd;
        String[] per=Get_star_rating_per(url_content);
        fdd.setTitle(Get_title(json));
        fdd.setPublish_date(Get_publish_date(json));
        fdd.setDirector(Get_director(json));
        fdd.setAuthor(Get_author(json));
        fdd.setActor(Get_actor(json));
        fdd.setType(Get_type(json));
        fdd.setMake_location(Get_makelocation(url_content));
        fdd.setLanguage(Get_language(url_content));
        fdd.setShow_date(Get_showdate(url_content));
        fdd.setLength(Get_length(url_content));
        fdd.setOther_name(Get_othername(url_content));
        fdd.setIMDb_link(Get_IMDbLink(url_content));
        fdd.setRatingValue(Get_ratingValue(json));
        fdd.setComment_num(Get_comment_num(json));
        fdd.setStar1_rating_per(per[0]);
        fdd.setStar2_rating_per(per[1]);
        fdd.setStar3_rating_per(per[2]);
        fdd.setStar4_rating_per(per[3]);
        fdd.setStar5_rating_per(per[4]);
        fdd.setDescription(Get_description(url_content));
        fdd.setImg_url(Get_img_url(json));
        fdd.setDetail_link(Get_detail_link(json));
        return fdd;
    }

    //获取网页内容的json数据
    private String GetJsonContent(String content){
        return content.substring(content.indexOf(all.FILMDETAIL_JSON_START)+all.FILMDETAIL_JSON_START.length(),
                content.indexOf(all.FILMDETAIL_JSON_END,content.indexOf(all.FILMDETAIL_JSON_START)));
    }

    //从获取的json数据中获取指定字段的值
    private String GetJsonSomeContent(String json, String name, String start_str){
        if(start_str.equals("["))
            return json.substring(json.indexOf(name)+name.length(),json.indexOf("]",json.indexOf(name)));
        else
            return json.substring(json.indexOf(name+": ")+(name+": \"").length(),json.indexOf("\"",json.indexOf(name)+(name+": \"").length()+1));
    }

    //从json某一字段的所有内容中抽取出符合特定字段的所有值
    private String GetAllNamesFromJsonContent(String content, String name){
        int count=1;
        int last_start=0;
        StringBuilder all_content= new StringBuilder();
        while(content.indexOf(name,last_start)!=-1){
            last_start=content.indexOf(name,last_start);
            if(count!=1)
                all_content.append(" / ");
            all_content.append(content.substring(content.indexOf(name, last_start) + (name + ": \"").length(),
                    content.indexOf("\"", content.indexOf(name, last_start) + (name + ": \"").length())));
            last_start=content.indexOf("\"",content.indexOf(name,last_start)+(name+": \"").length());
            ++count;
        }
        return all_content.toString();
    }

    //获取电影标题
    private String Get_title(String json){
        return GetJsonSomeContent(json,all.FILMDETAIL_TITLE_NAME,all.FILMDETAIL_TITLE_START)
                .replace("&#39;","'")
                .replace("&amp;","&");
    }

    //获取电影发行日期
    private String Get_publish_date(String json){
        return GetJsonSomeContent(json,all.FILMDETAIL_PUBLISH_DATE_NAME,all.FILMDETAIL_PUBLISH_DATE_START);
    }

    //获取电影的导演信息
    private String Get_director(String json){
        return GetAllNamesFromJsonContent(GetJsonSomeContent(json,all.FILMDETAIL_DIRECTOR_NAME,"["),all.FILMDETAIL_DIRECTOR_ALLNAMES);
    }

    //获取电影的编剧信息
    private String Get_author(String json){
        return GetAllNamesFromJsonContent(GetJsonSomeContent(json,all.FILMDETAIL_AUTHOR_NAME,"["),all.FILMDETAIL_AUTHOR_ALLNAMES);
    }

    //获取电影的主演信息
    private String Get_actor(String json){
        return GetAllNamesFromJsonContent(GetJsonSomeContent(json,all.FILMDETAIL_ACTOR_NAME,"["),all.FILMDETAIL_ACTOR_ALLNAMES);
    }

    //获取电影的类型
    private String Get_type(String json){
        String all_content=GetJsonSomeContent(json,all.FILMDETAIL_TYPE_NAME,"[");
        LinkedList<String> all_type_encode=new LinkedList<>();
        if(all_content.contains(", ")){
            String[] all_type_encode_string=all_content.split(", ");
            for (String s : all_type_encode_string) all_type_encode.add(ud.unicodeToString(s.replace("\"", "")));
            StringBuilder result= new StringBuilder();
            for(int i=0;i<all_type_encode.size();i++){
                if(i==0)
                    result.append(all_type_encode.get(i));
                else
                    result.append(" / ").append(all_type_encode.get(i));
            }
            return result.toString();
        }
        else
            return ud.unicodeToString(all_content.replace("\"",""));
    }

    //获取电影的制片国家/地区
    private String Get_makelocation(String content){
        return content.substring(content.indexOf(all.FILEDETAIL_MAKELOCATION_START)+all.FILEDETAIL_MAKELOCATION_START.length(),
                content.indexOf(all.FILMDETAIL_MAKELOCATION_END,content.indexOf(all.FILEDETAIL_MAKELOCATION_START)));
    }

    //获取电影的语言
    private String Get_language(String content){
        return content.substring(content.indexOf(all.FILMDETAIL_LANGUAGE_START)+all.FILMDETAIL_LANGUAGE_START.length(),
                content.indexOf(all.FILMDETAIL_LANGUAGE_END,content.indexOf(all.FILMDETAIL_LANGUAGE_START)));
    }

    //获取电影的上映日期
    private String Get_showdate(String content){
        String con=content.substring(content.indexOf(all.FILMDETAIL_SHOWDATE_START)+all.FILMDETAIL_SHOWDATE_START.length(),
                content.indexOf(all.FILMDETAIL_SHOWDATE_END,content.indexOf(all.FILMDETAIL_SHOWDATE_START)));
        String info=con.replace("<span property=\"v:initialReleaseDate\" content=\"","")
                .replace("</span>","");
        StringBuilder result= new StringBuilder();
        if(info.contains(" / ")){
            String[] info2=info.split(" / ");
            for(int i=0;i<info2.length;i++)
                info2[i]=info2[i].substring(0,info2[i].indexOf("\">"));
            for(int i=0;i<info2.length;i++)
                if(i==0)
                    result.append(info2[i]);
                else
                    result.append(" / ").append(info2[i]);
        }
        else
            result = new StringBuilder(info.substring(info.indexOf("\">") + ("\">").length()));
        return result.toString();
    }

    //获取电影的片长
    private String Get_length(String content){
        String info=content.substring(content.indexOf(all.FILMDETAIL_LENGTH_START)+all.FILMDETAIL_LENGTH_START.length(),
                content.indexOf(all.FILMDETAIL_LENGTH_END,content.indexOf(all.FILMDETAIL_LENGTH_START)));
        return info.substring(info.indexOf("\">")+("\">").length()).replace("</span>","");
    }

    //获取电影的其他名称
    private String Get_othername(String content){
        if(content.contains(all.FILMDETAIL_OTHERNAME_START))
            return content.substring(content.indexOf(all.FILMDETAIL_OTHERNAME_START)+all.FILMDETAIL_OTHERNAME_START.length(),
                content.indexOf(all.FILMDETAIL_OTHERNAME_END,content.indexOf(all.FILMDETAIL_OTHERNAME_START)));
        else
            return "";
    }

    //获取电影的IMDb链接
    private String Get_IMDbLink(String content){
        return content.substring(content.indexOf(all.FILMDETAIL_IMDBLINK_START)+all.FILMDETAIL_IMDBLINK_START.length(),
                content.indexOf(all.FILMDETAIL_IMDBLINK_END,content.indexOf(all.FILMDETAIL_IMDBLINK_START)));
    }

    //获取电影的评分
    private String Get_ratingValue(String json){
        return GetJsonSomeContent(json,all.FILMDETAIL_RATINGVALUE_NAME,"\"");
    }

    //获取电影的评分人数
    private String Get_comment_num(String json){
        return GetJsonSomeContent(json,all.FILMDETAIL_COMMENTNUM_NAME,"\"");
    }

    //获取电影的1-5星的所占百分比
    private String[] Get_star_rating_per(String content){
        String[] per=new String[5];
        String con0=content.substring(content.indexOf(all.FILMDETAIL_STAR1_RATING_PER));
        per[0]=con0.substring(con0.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)+all.FILMDETAIL_STAR_RATING_PER_START.length(),
                        con0.indexOf(all.FILMDETAIL_STAR_RATING_PER_END,con0.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)));
        String con1=content.substring(content.indexOf(all.FILMDETAIL_STAR2_RATING_PER));
        per[1]=con1.substring(con1.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)+all.FILMDETAIL_STAR_RATING_PER_START.length(),
                con1.indexOf(all.FILMDETAIL_STAR_RATING_PER_END,con1.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)));
        String con2=content.substring(content.indexOf(all.FILMDETAIL_STAR3_RATING_PER));
        per[2]=con2.substring(con2.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)+all.FILMDETAIL_STAR_RATING_PER_START.length(),
                con2.indexOf(all.FILMDETAIL_STAR_RATING_PER_END,con2.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)));
        String con3=content.substring(content.indexOf(all.FILMDETAIL_STAR4_RATING_PER));
        per[3]=con3.substring(con3.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)+all.FILMDETAIL_STAR_RATING_PER_START.length(),
                con3.indexOf(all.FILMDETAIL_STAR_RATING_PER_END,con3.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)));
        String con4=content.substring(content.indexOf(all.FILMDETAIL_STAR5_RATING_PER));
        per[4]=con4.substring(con4.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)+all.FILMDETAIL_STAR_RATING_PER_START.length(),
                con4.indexOf(all.FILMDETAIL_STAR_RATING_PER_END,con4.indexOf(all.FILMDETAIL_STAR_RATING_PER_START)));
        return per;
    }

    //获取电影的介绍
    private String Get_description(String content){
        String con;
        if(content.contains(all.FILMDETAIL_DESCRIPTION_START2))
            con=content.substring(content.indexOf(all.FILMDETAIL_DESCRIPTION_START2)+all.FILMDETAIL_DESCRIPTION_START2.length(),
                    content.indexOf(all.FILMDETAIL_DESCRIPTION_END,content.indexOf(all.FILMDETAIL_DESCRIPTION_START2)));
        else
            con=content.substring(content.indexOf(all.FILMDETAIL_DESCRIPTION_START1)+all.FILMDETAIL_DESCRIPTION_START1.length(),
                    content.indexOf(all.FILMDETAIL_DESCRIPTION_END,content.indexOf(all.FILMDETAIL_DESCRIPTION_START1)));
        String[] all_line=con.split("<br />");
        StringBuilder result= new StringBuilder();
        for(int i=0;i<all_line.length;i++){
            all_line[i]=all_line[i].trim().replace("　","");
            if(i==0)
                result.append(all_line[i]);
            else
                result.append(System.getProperty("line.separator")).append(all_line[i]);
        }
        return result.toString();
    }

    //获取电影的图片链接
    private String Get_img_url(String json){
        return GetJsonSomeContent(json,all.FILMDETAIL_IMGURL_NAME,"\"");
    }

    //获取电影的详情页链接
    private String Get_detail_link(String json){
        return all.FILMDETAIL_LINK_HEAD+GetJsonSomeContent(json,all.FILMDETAIL_LINK_NAME,"\"");
    }
}
