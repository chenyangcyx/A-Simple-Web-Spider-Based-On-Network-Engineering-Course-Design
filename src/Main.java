import Analysis.GetAllInfoFromDetailPage;
import Analysis.GetAllInfoFromList;
import Connection.GetHttpContent;

public class Main {
    public static void main(String[] args) {
        GetHttpContent test0=new GetHttpContent("https://movie.douban.com/subject/1292052/");
        String con0=test0.GetContent();
        GetAllInfoFromDetailPage getAllInfoFromDetailPage=new GetAllInfoFromDetailPage(con0);
        getAllInfoFromDetailPage.GetInfo();
    }
}
