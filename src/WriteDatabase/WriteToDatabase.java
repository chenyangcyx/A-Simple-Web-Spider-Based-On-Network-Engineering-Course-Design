package WriteDatabase;

import DataDefinition.FilmDetailData;
import DataDefinition.FilmListData;
import DataDefinition.OverAllData;

import java.sql.*;

public class WriteToDatabase {
    OverAllData all=OverAllData.overall;
    Connection conn = null;

    public WriteToDatabase(){
        ConnectMySql();
    }

    void ConnectMySql()
    {
        try
        {
            // 注册 JDBC 驱动
            Class.forName(all.JDBC_DRIVER);
            conn = DriverManager.getConnection(all.SQLAddress,all.SQL_ACCOUNT,all.SQL_PASSWORD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //写入listdata
    public void WriteListData(FilmListData fld){
        PreparedStatement pre=null;
        try {
            pre=conn.prepareStatement("insert into `listdata` values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pre.setString(1,fld.getRank_num());
            pre.setString(2,fld.getCh_name());
            pre.setString(3,fld.getEng_name());
            pre.setString(4,fld.getOther_name());
            pre.setString(5,fld.getTitle());
            pre.setString(6,fld.getPlayable());
            pre.setString(7,fld.getBase_info());
            pre.setString(8,fld.getType());
            pre.setString(9,fld.getScore());
            pre.setString(10,fld.getComment_num());
            pre.setString(11,fld.getShort_comment());
            pre.setString(12,fld.getImg_url());
            pre.setString(13,fld.getDetail_page_url());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("将"+fld.getCh_name()+"的信息写入数据库！"+System.getProperty("line.separator"));
    }

    //写入detaildata
    public void WriteDetailData(FilmDetailData fdd){
        PreparedStatement pre=null;
        try {
            pre=conn.prepareStatement("insert into `detaildata` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pre.setString(1,fdd.getTitle());
            pre.setString(2,fdd.getPublish_date());
            pre.setString(3,fdd.getDirector());
            pre.setString(4,fdd.getAuthor());
            pre.setString(5,fdd.getActor());
            pre.setString(6,fdd.getType());
            pre.setString(7,fdd.getMake_location());
            pre.setString(8,fdd.getLanguage());
            pre.setString(9,fdd.getShow_date());
            pre.setString(10,fdd.getLength());
            pre.setString(11,fdd.getOther_name());
            pre.setString(12,fdd.getIMDb_link());
            pre.setString(13,fdd.getRatingValue());
            pre.setString(14,fdd.getComment_num());
            pre.setString(15,fdd.getStar5_rating_per());
            pre.setString(16,fdd.getStar4_rating_per());
            pre.setString(17,fdd.getStar3_rating_per());
            pre.setString(18,fdd.getStar2_rating_per());
            pre.setString(19,fdd.getStar1_rating_per());
            pre.setString(20,fdd.getDescription());
            pre.setString(21,fdd.getImg_url());
            pre.setString(22,fdd.getDetail_link());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("将"+fdd.getTitle()+"的信息写入数据库！"+System.getProperty("line.separator"));
    }
}
