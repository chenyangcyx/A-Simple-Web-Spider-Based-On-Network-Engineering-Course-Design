package FileOperation;
import DataDefinition.FilmListData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class WriteListInfoToFile {
    private LinkedList<FilmListData> all_list;

    public WriteListInfoToFile(LinkedList<FilmListData> list){
        this.all_list=list;
    }

    //获取当前的目录
    public String GetCurrentPath(){
        File directory=new File(".");
        String path="";
        try {
            path=directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    //在目录中创建文件夹
    public String MakeFolder(String path,String folder_name){
        String folder_path=path+"/"+folder_name;
        File folder=new File(folder_path);
        if(!folder.exists())
            folder.mkdir();
        return folder_path;
    }

    //写入列表信息
    public void WriteListContent(String path){
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(path+"/"+"list.txt"));
            DownloadFile df=new DownloadFile();
            for (FilmListData filmListData : all_list) {
                System.out.println("写入文件 : " + filmListData.getTitle());

                bw.write("排名 : " + filmListData.getRank_num() + System.getProperty("line.separator"));
                bw.write("中文名 : " + filmListData.getCh_name() + System.getProperty("line.separator"));
                bw.write("外文名 : " + filmListData.getEng_name() + System.getProperty("line.separator"));
                bw.write("又名 : " + filmListData.getOther_name() + System.getProperty("line.separator"));
                bw.write("标题 : " + filmListData.getTitle() + System.getProperty("line.separator"));
                bw.write("是否可播放 : " + filmListData.getPlayable() + System.getProperty("line.separator"));
                bw.write("基本信息 : " + filmListData.getBase_info() + System.getProperty("line.separator"));
                bw.write("类型 : " + filmListData.getType() + System.getProperty("line.separator"));
                bw.write("得分 : " + filmListData.getScore() + System.getProperty("line.separator"));
                bw.write("评论次数 : " + filmListData.getComment_num() + System.getProperty("line.separator"));
                bw.write("简评 : " + filmListData.getShort_comment() + System.getProperty("line.separator"));
                bw.write("海报地址 : " + filmListData.getImg_url() + System.getProperty("line.separator"));
                bw.write("详细页面地址 : " + filmListData.getDetail_page_url() + System.getProperty("line.separator"));
                //下载海报图片
                System.out.println("下载海报图片 : " + filmListData.getRank_num()
                        + filmListData.getImg_url().substring(filmListData.getImg_url().lastIndexOf('.'))
                        + " 到 " + path + "/" + filmListData.getRank_num() + filmListData.getImg_url().substring(filmListData.getImg_url().lastIndexOf('.'))
                        + System.getProperty("line.separator"));
                df.downloadFile(filmListData.getImg_url(), path + "/" + filmListData.getRank_num() + filmListData.getImg_url().substring(filmListData.getImg_url().lastIndexOf('.')));
                bw.write(System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator"));
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
