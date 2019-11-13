package Analysis;
import DataProcess.ListFilmData;
import DataProcess.OverAllData;
import java.util.LinkedList;

//获取排行榜列表的所有信息
public class GetAllInfoFromList {
    OverAllData all=OverAllData.overall;

    String url_content;

    public GetAllInfoFromList(String content){
        this.url_content=content;
    }

    public LinkedList<ListFilmData> GetInfo(){
        LinkedList<String> all_match=GetAllMatchString(url_content, all.FILMLIST_GETINFO_START,all.FILMLIST_GETINFO_END);
        LinkedList<ListFilmData> all_lfd=new LinkedList<ListFilmData>();
        //遍历所有获得的电影信息
        for(int i=0;i<all_match.size();i++){
            ListFilmData lfd=new ListFilmData();
            //获取排名
            lfd.setRank_num(Get_rank_num(all_match.get(i)));
            //获取中文名
            lfd.setCh_name(Get_ch_name(all_match.get(i)));
            //获取英文名
            lfd.setEng_name(Get_eng_name(all_match.get(i)));
            //获取其他名
            lfd.setOther_name(Get_other_name(all_match.get(i)));
            //获取标题
            lfd.setTitle(Get_title(all_match.get(i)));
            //获取是否可播放
            lfd.setPlayable(Get_playable(all_match.get(i)));
            //获取基本信息
            lfd.setBase_info(Get_baseinfo(all_match.get(i)));
            //获取类型
            lfd.setType(Get_type(all_match.get(i)));
            //获取评分
            lfd.setScore(Get_score(all_match.get(i)));
            //获取评论次数
            lfd.setComment_num(Get_comment_num(all_match.get(i)));
            //获取简评
            lfd.setShort_comment(Get_short_comment(all_match.get(i)));
            //获取图片链接
            lfd.setImg_url(Get_img_url(all_match.get(i)));
            //获取详细页面链接
            lfd.setDetail_page_url(Get_detail_page_url(all_match.get(i)));

            all_lfd.add(lfd);
        }
        return all_lfd;
    }

    public LinkedList<String> GetAllMatchString(String content, String start_str, String end_str){
        int last_start=0;
        LinkedList<String> all_match=new LinkedList<>();
        while(content.indexOf(start_str,last_start)!=-1){
            last_start=content.indexOf(start_str,last_start);
            all_match.add(content.substring(content.indexOf(start_str,last_start),content.indexOf(end_str,last_start)));
            if(all_match.getLast().contains(all.FILMLIST_GETINFO_CHECK_IFOK))
                all_match.removeLast();
            last_start++;
        }
        return all_match;
    }

    //获得电影的排名
    public String Get_rank_num(String content){
        return content.substring(content.indexOf(all.FILMLIST_RANKNUM_START)+all.FILMLIST_RANKNUM_START.length(),
                content.indexOf(all.FILMLIST_RANKNUM_END));
    }

    //获得电影的中文名
    public String Get_ch_name(String content){
        return content.substring(content.indexOf(all.FILMLIST_CHNAME_START)+all.FILMLIST_CHNAME_START.length(),
                content.indexOf(all.FILMLIST_CHNAME_END));
    }

    //获得电影的英文名
    public String Get_eng_name(String content){
        if(!content.substring(content.indexOf(all.FILMLIST_CHNAME_START)+all.FILMLIST_CHNAME_START.length(),
                content.indexOf(all.FILMLIST_OTHERNAME_START)).contains(all.FILMLIST_ENGNAME_START))
            return "";
        else
            return content.substring(content.indexOf(all.FILMLIST_ENGNAME_START,
                    content.indexOf(all.FILMLIST_ENGNAME_START)+1)+all.FILMLIST_ENGNAME_START.length(),
                content.indexOf(all.FILMLIST_ENGNAME_END,content.indexOf(all.FILMLIST_ENGNAME_END)+1))
                .replace("&nbsp;/&nbsp;","")
                .replace("&#39;","'");
    }

    //获得电影的其他名
    public String Get_other_name(String content){
        return content.substring(content.indexOf(all.FILMLIST_OTHERNAME_START)+all.FILMLIST_OTHERNAME_START.length(),
                content.indexOf(all.FILMLIST_OTHERNAME_END,content.indexOf(all.FILMLIST_OTHERNAME_START)))
                .replace("&nbsp;/&nbsp;","")
                .replace("&#39;","'");
    }

    //获得电影的标题
    public String Get_title(String content){
        return Get_ch_name(content)+"  / "+Get_eng_name(content)+"  / "+Get_other_name(content);
    }

    //获得电影是否可播放
    public String Get_playable(String content){
        if(content.contains(all.FILMLIST_PLAYABLE_START))
            return content.substring(content.indexOf(all.FILMLIST_PLAYABLE_START)+all.FILMLIST_PLAYABLE_START.length(),
                content.indexOf(all.FILMLIST_PLAYABLE_END,content.indexOf(all.FILMLIST_PLAYABLE_START)))
                .replace("[","")
                .replace("]","");
        else
            return "不可播放";
    }

    //获得电影的基本信息
    public String Get_baseinfo(String content){
        return content.substring(content.indexOf(all.FILMLIST_BASEINFO_START),
                content.indexOf(all.FILMLIST_BASEINFO_END))
                .replace("&nbsp;"," ")
                .replace("&#39;","'");
    }

    //获得电影的类型
    public String Get_type(String content){
        return content.substring(content.indexOf(all.FILMLIST_TYPE_START)+all.FILMLIST_TYPE_START.length(),
                content.indexOf(all.FILMLIST_TYPE_END))
                .trim()
                .replace("&nbsp;"," ")
                .replace("&#39;","'");
    }

    //获得电影的分数
    public String Get_score(String content){
        return content.substring(content.indexOf(all.FILMLIST_SCORE_START)+all.FILMLIST_SCORE_START.length(),
                content.indexOf(all.FILMLIST_SCORE_END,content.indexOf(all.FILMLIST_SCORE_START)));
    }

    //获得电影的评价次数
    public String Get_comment_num(String content){
        return content.substring(content.indexOf(all.FILMLIST_COMMENTNUM_START)+all.FILMLIST_COMMENTNUM_START.length(),
                content.indexOf(all.FILMLIST_COMMENTNUM_END,content.indexOf(all.FILMLIST_COMMENTNUM_START)));
    }

    //获得电影的简评
    public String Get_short_comment(String content){
        if(content.contains(all.FILMLIST_SHORTCOMMENT_START))
            return content.substring(content.indexOf(all.FILMLIST_SHORTCOMMENT_START)+all.FILMLIST_SHORTCOMMENT_START.length(),
                content.indexOf(all.FILMLIST_SHORTCOMMENT_END,content.indexOf(all.FILMLIST_SHORTCOMMENT_START)));
        else
            return "";
    }

    //获得电影图片的链接
    public String Get_img_url(String content){
        return content.substring(content.indexOf(all.FILMLIST_IMGURL_START)+all.FILMLIST_IMGURL_START.length(),
                content.indexOf(all.FILMLIST_IMGURL_END));
    }

    //获得电影的详细链接
    public String Get_detail_page_url(String content){
        return content.substring(content.indexOf(all.FILMLIST_DETAILPAGEURL_START)+all.FILMLIST_DETAILPAGEURL_START.length(),
                content.indexOf(all.FILMLIST_DETAILPAGEURL_END,content.indexOf(all.FILMLIST_DETAILPAGEURL_START)));
    }
}