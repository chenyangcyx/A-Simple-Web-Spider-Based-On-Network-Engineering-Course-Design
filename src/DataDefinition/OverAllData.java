package DataDefinition;

public class OverAllData {
    public static OverAllData overall=new OverAllData();

    //电影TOP250列表的链接
    public String FILMLIST_URL="https://movie.douban.com/top250?start=";

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
    public String FILMDETAIL_TITLE_NAME="\"name\"";
    public String FILMDETAIL_TITLE_START="\"";
    //电影发行日期
    public String FILMDETAIL_PUBLISH_DATE_NAME="\"datePublished\"";
    public String FILMDETAIL_PUBLISH_DATE_START="\"";
    //电影导演
    public String FILMDETAIL_DIRECTOR_NAME="\"director\"";
    public String FILMDETAIL_DIRECTOR_ALLNAMES="\"name\"";
    //电影编剧
    public String FILMDETAIL_AUTHOR_NAME="\"author\"";
    public String FILMDETAIL_AUTHOR_ALLNAMES="\"name\"";
    //电影主演
    public String FILMDETAIL_ACTOR_NAME="\"actor\"";
    public String FILMDETAIL_ACTOR_ALLNAMES="\"name\"";
    //电影类型
    public String FILMDETAIL_TYPE_NAME="\"genre\": [";
    //电影制片国家/地区
    public String FILEDETAIL_MAKELOCATION_START="<span class=\"pl\">制片国家/地区:</span> ";
    public String FILMDETAIL_MAKELOCATION_END="<br/>";
    //电影的语言
    public String FILMDETAIL_LANGUAGE_START="<span class=\"pl\">语言:</span> ";
    public String FILMDETAIL_LANGUAGE_END="<br/>";
    //电影的上映日期
    public String FILMDETAIL_SHOWDATE_START="<span class=\"pl\">上映日期:</span> ";
    public String FILMDETAIL_SHOWDATE_END="<br/>";
    //电影的片长
    public String FILMDETAIL_LENGTH_START="<span class=\"pl\">片长:</span> <span property=\"v:runtime\" content=\"";
    public String FILMDETAIL_LENGTH_END="<br/>";
    //电影的其他名称
    public String FILMDETAIL_OTHERNAME_START="<span class=\"pl\">又名:</span> ";
    public String FILMDETAIL_OTHERNAME_END="<br/>";
    //电影的IMDb链接
    public String FILMDETAIL_IMDBLINK_START="<span class=\"pl\">IMDb链接:</span> <a href=\"";
    public String FILMDETAIL_IMDBLINK_END="\" target=\"_blank\"";
    //电影的评分
    public String FILMDETAIL_RATINGVALUE_NAME="\"ratingValue\"";
    //电影的评论数
    public String FILMDETAIL_COMMENTNUM_NAME="\"ratingCount\"";
    //电影的1-5星评分所占百分比
    public String FILMDETAIL_STAR5_RATING_PER="<span class=\"stars5 starstop\"";
    public String FILMDETAIL_STAR4_RATING_PER="<span class=\"stars4 starstop\"";
    public String FILMDETAIL_STAR3_RATING_PER="<span class=\"stars3 starstop\"";
    public String FILMDETAIL_STAR2_RATING_PER="<span class=\"stars2 starstop\"";
    public String FILMDETAIL_STAR1_RATING_PER="<span class=\"stars1 starstop\"";
    public String FILMDETAIL_STAR_RATING_PER_START="<span class=\"rating_per\">";
    public String FILMDETAIL_STAR_RATING_PER_END="</span>";
    //电影的剧情简介
    public String FILMDETAIL_DESCRIPTION_START1="<span property=\"v:summary\" class=\"\">";
    public String FILMDETAIL_DESCRIPTION_START2="<span class=\"all hidden\">";
    public String FILMDETAIL_DESCRIPTION_END="</span>";
    //电影的图片链接
    public String FILMDETAIL_IMGURL_NAME="\"image\"";
    //电影的详情链接
    public String FILMDETAIL_LINK_HEAD="https://movie.douban.com";
    public String FILMDETAIL_LINK_NAME="\"url\"";
    /*----------电影详细页面的处理-获取网页中每个信息所需要的特征码----------*/

    /*----------数据库处理----------*/
    public String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public String SQLAddress="jdbc:mysql://47.100.206.8:3306/filmdata?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    public String SQL_ACCOUNT="filmdata";
    public String SQL_PASSWORD="filmdatafilmdatafilmdatafilmdata";
    /*----------数据库处理----------*/
}
