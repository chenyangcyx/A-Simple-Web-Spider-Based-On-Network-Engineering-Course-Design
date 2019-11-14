import DataDefinition.FilmDetailData;
import DataDefinition.FilmListData;
import FileOperation.WriteDetailInfoToFile;
import FileOperation.WriteListInfoToFile;
import GetData.GetAllListData;
import GetData.GetDetailData;
import WriteDatabase.WriteToDatabase;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //准备数据库
        WriteToDatabase wtb=new WriteToDatabase();
        /*列表相关*/
        //获取排行榜上所有的电影信息
        LinkedList<FilmListData> fld=new GetAllListData().GetData();
        //创建文件夹
        WriteListInfoToFile wlitf=new WriteListInfoToFile(fld);
        String list_path=wlitf.MakeFolder(wlitf.GetCurrentPath(),"list");
        //写入基本信息
        wlitf.WriteListContent(list_path);
        //写入数据库
        for (FilmListData listData : fld) wtb.WriteListData(listData);
        /*列表相关*/

        /*详情页面相关*/
        //创建文件夹
        WriteDetailInfoToFile wditf=new WriteDetailInfoToFile();
        String detail_path=wditf.MakeFolder(wditf.GetCurrentPath(),"detail");
        //根据排行榜所有电影信息获取所有电影详细信息，并写入文件
        for (FilmListData filmListData : fld) {
            //获取电影的详情信息
            FilmDetailData fdd = new GetDetailData(filmListData.getDetail_page_url()).GetData();
            //将详情信息写入文件
            wditf.WriteDetailContent(fdd, detail_path,
                    filmListData.getRank_num() + " - " + filmListData.getCh_name());
            //写入数据库
            wtb.WriteDetailData(fdd);
        }
        /*详情页面相关*/
    }
}
