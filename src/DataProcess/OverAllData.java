package DataProcess;

public class OverAllData {
    public static OverAllData overall=new OverAllData();

    /*----------电影列表的处理-获取字符串的匹配项所需要的特征码----------*/
    //电影列表的整段
    public String FILMLIST_GETINFO_START="<li>";
    public String FILMLIST_GETINFO_END="</li>";
    public String FILMLIST_GETINFO_CHECK_IFOK="豆瓣摄影";
    //电影的排名
    public String FILMLIST_RANKNUM_START="<em class=\"\">";
    public String FILMLIST_RANKNUM_END="</em>";
    //电影中文名称
    public String FILMLIST_CHNAME_START="<span class=\"title\">";
    public String FILMLIST_CHNAME_END="</span>";
    //电影英文名称
    public String FILMLIST_ENGNAME_START="<span class=\"title\">";
    public String FILMLIST_ENGNAME_END="</span>";
    //电影其他名称
    public String FILMLIST_OTHERNAME_START="<span class=\"other\">";
    public String FILMLIST_OTHERNAME_END="</span>";
    //电影是否可播放
    public String FILMLIST_PLAYABLE_START="<span class=\"playable\">";
    public String FILMLIST_PLAYABLE_END="</span>";
    //电影的基本信息
    public String FILMLIST_BASEINFO_START="导演:";
    public String FILMLIST_BASEINFO_END="<br>";
    //电影的类型
    public String FILMLIST_TYPE_START="<br>";
    public String FILMLIST_TYPE_END="</p>";
    //电影的分数
    public String FILMLIST_SCORE_START="<span class=\"rating_num\" property=\"v:average\">";
    public String FILMLIST_SCORE_END="</span>";
    //电影的评价次数
    public String FILMLIST_COMMENTNUM_START="<span>";
    public String FILMLIST_COMMENTNUM_END="</span>";
    //电影的简评
    public String FILMLIST_SHORTCOMMENT_START="<span class=\"inq\">";
    public String FILMLIST_SHORTCOMMENT_END="</span>";
    //电影的图片链接
    public String FILMLIST_IMGURL_START="src=\"";
    public String FILMLIST_IMGURL_END="\" class=\"\">";
    //电影的详情页链接
    public String FILMLIST_DETAILPAGEURL_START="<a href=\"";
    public String FILMLIST_DETAILPAGEURL_END="\">";
    /*----------电影列表的处理-获取字符串的匹配项所需要的特征码----------*/

    /*----------电影详细页面的处理-获取网页中每个信息所需要的特征码----------*/
    //JSON数据
    public String FILMDETAIL_JSON_START="<script type=\"application/ld+json\">";
    public String FILMDETAIL_JSON_END="</script>";
    //电影标题
    public String FILMDETAIL_TITLE_START="\"name\": ";
    public String FILMDETAIL_TITLE_END=",";
    //电影发行日期
    public String FILMDETAIL_PUBLISH_DATE_START="\"datePublished\": ";
    public String FILMDETAIL_PUBLISH_DATE_END=",";
    //电影导演
    public String FILMDETAIL_DIRECTOR_START1="\"director\":";
    public String FILMDETAIL_DIRECTOR_START2="\"name\": ";
    public String FILMDETAIL_DIRECTOR_END="\"";
    /*----------电影详细页面的处理-获取网页中每个信息所需要的特征码----------*/
}
