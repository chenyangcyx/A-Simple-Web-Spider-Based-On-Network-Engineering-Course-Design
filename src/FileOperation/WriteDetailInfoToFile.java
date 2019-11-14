package FileOperation;

import DataDefinition.FilmDetailData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDetailInfoToFile {
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

    //写入信息
    public void WriteDetailContent(FilmDetailData fdd, String path,String file_name) {
        //控制台输出
        System.out.println("获取到详情页信息："+fdd.getTitle());
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(path+"/"+file_name+".txt"));
            DownloadFile df=new DownloadFile();
            System.out.println("写入文件 : "+file_name+".txt");

            bw.write("标题 : "+fdd.getTitle()+System.getProperty("line.separator"));
            bw.write("发布时间 : "+fdd.getPublish_date()+System.getProperty("line.separator"));
            bw.write("导演 : "+fdd.getDirector()+System.getProperty("line.separator"));
            bw.write("编剧 : "+fdd.getAuthor()+System.getProperty("line.separator"));
            bw.write("主演 : "+fdd.getActor()+System.getProperty("line.separator"));
            bw.write("类型 : "+fdd.getType()+System.getProperty("line.separator"));
            bw.write("制片国家/地区 : "+fdd.getMake_location()+System.getProperty("line.separator"));
            bw.write("语言 : "+fdd.getLanguage()+System.getProperty("line.separator"));
            bw.write("上映日期 : "+fdd.getShow_date()+System.getProperty("line.separator"));
            bw.write("片长 : "+fdd.getLength()+System.getProperty("line.separator"));
            bw.write("又名 : "+fdd.getOther_name()+System.getProperty("line.separator"));
            bw.write("IMDb链接 : "+fdd.getIMDb_link()+System.getProperty("line.separator"));
            bw.write("豆瓣评分 : "+fdd.getRatingValue()+System.getProperty("line.separator"));
            bw.write("评价次数 : "+fdd.getComment_num()+System.getProperty("line.separator"));
            bw.write("5星评价所占比例 : "+fdd.getStar5_rating_per()+System.getProperty("line.separator"));
            bw.write("4星评价所占比例 : "+fdd.getStar4_rating_per()+System.getProperty("line.separator"));
            bw.write("3星评价所占比例 : "+fdd.getStar3_rating_per()+System.getProperty("line.separator"));
            bw.write("2星评价所占比例 : "+fdd.getStar2_rating_per()+System.getProperty("line.separator"));
            bw.write("1星评价所占比例 : "+fdd.getStar1_rating_per()+System.getProperty("line.separator"));
            bw.write("剧情简介 : "+fdd.getDescription()+System.getProperty("line.separator"));
            bw.write("图片链接 : "+fdd.getImg_url()+System.getProperty("line.separator"));
            bw.write("网址 : "+fdd.getDetail_link()+System.getProperty("line.separator"));

            //下载海报图片
            if(!fdd.getImg_url().equals("")){
                System.out.println("下载海报图片 : "+file_name+fdd.getImg_url().substring(fdd.getImg_url().lastIndexOf("."))
                        +" 到 "+path+"/"+file_name+fdd.getImg_url().substring(fdd.getImg_url().lastIndexOf(".")));
                df.downloadFile(fdd.getImg_url(),path+"/"+file_name+fdd.getImg_url().substring(fdd.getImg_url().lastIndexOf(".")));
            }
            else
                System.out.println("该电影的海报图片不可下载！");

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
