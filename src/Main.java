import Analysis.GetAllInfoFromList;
import Connection.GetHttpContent;

public class Main {
    public static void main(String[] args) {
        GetHttpContent test0=new GetHttpContent("https://movie.douban.com/top250?start=0&filter=");
        String con0=test0.GetContent();
        GetAllInfoFromList getAllInfoFromList0=new GetAllInfoFromList(con0);
        getAllInfoFromList0.GetInfo();

        GetHttpContent test25=new GetHttpContent("https://movie.douban.com/top250?start=25&filter=");
        String con25=test25.GetContent();
        GetAllInfoFromList getAllInfoFromList25=new GetAllInfoFromList(con25);
        getAllInfoFromList25.GetInfo();

        GetHttpContent test50=new GetHttpContent("https://movie.douban.com/top250?start=50&filter=");
        String con50=test50.GetContent();
        GetAllInfoFromList getAllInfoFromList50=new GetAllInfoFromList(con50);
        getAllInfoFromList50.GetInfo();

        GetHttpContent test75=new GetHttpContent("https://movie.douban.com/top250?start=75&filter=");
        String con75=test75.GetContent();
        GetAllInfoFromList getAllInfoFromList75=new GetAllInfoFromList(con75);
        getAllInfoFromList75.GetInfo();

        GetHttpContent test100=new GetHttpContent("https://movie.douban.com/top250?start=100&filter=");
        String con100=test100.GetContent();
        GetAllInfoFromList getAllInfoFromList100=new GetAllInfoFromList(con100);
        getAllInfoFromList100.GetInfo();

        GetHttpContent test125=new GetHttpContent("https://movie.douban.com/top250?start=125&filter=");
        String con125=test125.GetContent();
        GetAllInfoFromList getAllInfoFromList125=new GetAllInfoFromList(con125);
        getAllInfoFromList125.GetInfo();

        GetHttpContent test150=new GetHttpContent("https://movie.douban.com/top250?start=150&filter=");
        String con150=test150.GetContent();
        GetAllInfoFromList getAllInfoFromList150=new GetAllInfoFromList(con150);
        getAllInfoFromList150.GetInfo();

        GetHttpContent test175=new GetHttpContent("https://movie.douban.com/top250?start=175&filter=");
        String con175=test175.GetContent();
        GetAllInfoFromList getAllInfoFromList175=new GetAllInfoFromList(con175);
        getAllInfoFromList175.GetInfo();

        GetHttpContent test200=new GetHttpContent("https://movie.douban.com/top250?start=200&filter=");
        String con200=test200.GetContent();
        GetAllInfoFromList getAllInfoFromList200=new GetAllInfoFromList(con200);
        getAllInfoFromList200.GetInfo();

        GetHttpContent test225=new GetHttpContent("https://movie.douban.com/top250?start=225&filter=");
        String con225=test225.GetContent();
        GetAllInfoFromList getAllInfoFromList225=new GetAllInfoFromList(con225);
        getAllInfoFromList225.GetInfo();
    }
}
