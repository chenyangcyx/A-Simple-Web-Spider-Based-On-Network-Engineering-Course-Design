package GetData;
import Analysis.GetAllInfoFromList;
import Connection.GetHttpContent;
import DataDefinition.FilmListData;
import DataDefinition.OverAllData;
import java.util.LinkedList;

public class GetAllListData {
    private OverAllData all=OverAllData.overall;

    public LinkedList<FilmListData> GetData(){
        LinkedList<FilmListData> fld=new LinkedList<>();
        //获取列表网页的全部内容
        for(int i=0;i<=225;i+=25){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取网页内容
            String content=new GetHttpContent(all.FILMLIST_URL+i).GetContent();
            LinkedList<FilmListData> temp=new GetAllInfoFromList(content).GetInfo();
            for (FilmListData filmListData : temp) fld.add(filmListData);
        }
        return fld;
    }
}
