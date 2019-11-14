package FileOperation;

import DataDefinition.FilmListData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class WriteListInfoToFile {
    LinkedList<FilmListData> all_list=new LinkedList<>();

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
            for(int i=0;i<all_list.size();i++){
                System.out.println("写入文件 : "+all_list.get(i).getTitle());

                bw.write("排名 : "+all_list.get(i).getRank_num()+System.getProperty("line.separator"));
                bw.write("中文名 : "+all_list.get(i).getCh_name()+System.getProperty("line.separator"));
                bw.write("外文名 : "+all_list.get(i).getEng_name()+System.getProperty("line.separator"));
                bw.write("又名 : "+all_list.get(i).getOther_name()+System.getProperty("line.separator"));
                bw.write("标题 : "+all_list.get(i).getTitle()+System.getProperty("line.separator"));
                bw.write("是否可播放 : "+all_list.get(i).getPlayable()+System.getProperty("line.separator"));
                bw.write("基本信息 : "+all_list.get(i).getBase_info()+System.getProperty("line.separator"));
                bw.write("类型 : "+all_list.get(i).getType()+System.getProperty("line.separator"));
                bw.write("得分 : "+all_list.get(i).getScore()+System.getProperty("line.separator"));
                bw.write("评论次数 : "+all_list.get(i).getComment_num()+System.getProperty("line.separator"));
                bw.write("简评 : "+all_list.get(i).getShort_comment()+System.getProperty("line.separator"));
                bw.write("海报地址 : "+all_list.get(i).getImg_url()+System.getProperty("line.separator"));
                bw.write("详细页面地址 : "+all_list.get(i).getDetail_page_url()+System.getProperty("line.separator"));
                //下载海报图片
                System.out.println("下载海报图片 : "+all_list.get(i).getRank_num()
                        +all_list.get(i).getImg_url().substring(all_list.get(i).getImg_url().lastIndexOf('.'))
                        +" 到 "+path+"/"+all_list.get(i).getRank_num()+all_list.get(i).getImg_url().substring(all_list.get(i).getImg_url().lastIndexOf('.')));
                df.downloadFile(all_list.get(i).getImg_url(),path+"/"+all_list.get(i).getRank_num()+all_list.get(i).getImg_url().substring(all_list.get(i).getImg_url().lastIndexOf('.')));
                bw.write(System.getProperty("line.separator")+System.getProperty("line.separator")+System.getProperty("line.separator")+System.getProperty("line.separator"));
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
