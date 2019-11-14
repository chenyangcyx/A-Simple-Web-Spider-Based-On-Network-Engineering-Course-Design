package GetData;
import Analysis.GetAllInfoFromDetailPage;
import Connection.GetHttpContent;
import DataDefinition.FilmDetailData;

public class GetDetailData {
    private String url;

    public GetDetailData(String url){
        this.url =url;
    }

    public FilmDetailData GetData(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取详情页的内容
        String content=new GetHttpContent(url).GetContent();
        //从详情页中获取数据，并添加到LinkedList中
        return new GetAllInfoFromDetailPage(content).GetInfo();
    }
}
