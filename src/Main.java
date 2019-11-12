import Analysis.GetAllInfoFromList;
import Connection.GetHttpContent;

public class Main {
    public static void main(String[] args) {
        GetHttpContent test=new GetHttpContent("https://movie.douban.com/top250?start=0&filter=");
        String con=test.GetContent();
        GetAllInfoFromList getAllInfoFromList=new GetAllInfoFromList(con);
        getAllInfoFromList.GetInfo();
    }
}
