package GetData;

import Analysis.GetAllInfoFromDetailPage;
import Connection.GetHttpContent;
import DataDefinition.FilmDetailData;
import DataDefinition.FilmListData;
import java.util.LinkedList;

public class GetDetailData {
    String url_content;

    public GetDetailData(String url){
        this.url_content=url;
    }

    public FilmDetailData GetDataAndWrite(){
        //获取详情页的内容
        String content=new GetHttpContent(url_content).GetContent();
        //从详情页中获取数据，并添加到LinkedList中
        return new GetAllInfoFromDetailPage(content).GetInfo();
    }
}
